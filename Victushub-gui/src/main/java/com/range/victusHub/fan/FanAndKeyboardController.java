package com.range.victusHub.fan;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.nio.file.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

public class FanAndKeyboardController {

    private final Logger logger = LoggerFactory.getLogger(FanAndKeyboardController.class);
    private List<Path> fanPaths;
    private final List<Slider> fanSliders = new ArrayList<>();
    private final List<Label> fanLabels = new ArrayList<>();

    @FXML
    private VBox fanContainer;

    @FXML
    private Slider suryaLightSlider;
    @FXML
    private Label lightValueLabel;

    @FXML
    private ColorPicker colorPicker;

    private static final Path CONFIG_PATH = Path.of(System.getProperty("user.home"), ".config/victusservice/victus.config");

    @FXML
    private void initialize() {
        fanPaths = detectFanPaths();
        for (int i = 0; i < fanPaths.size(); i++) {
            Slider slider = new Slider(0, 10000, 0);
            slider.setShowTickLabels(true);
            slider.setShowTickMarks(true);

            Label label = new Label("Current RPM: 0");
            slider.valueProperty().addListener((obs, oldVal, newVal) ->
                    label.setText("Current RPM: " + newVal.intValue()));

            Button applyButton = new Button("Apply");
            int index = i;
            applyButton.setOnAction(e -> applyFanSpeed(index));

            VBox fanBox = new VBox(5, new Label("Fan " + (i + 1)), slider, label, applyButton);
            fanContainer.getChildren().add(fanBox);
            fanSliders.add(slider);
            fanLabels.add(label);
        }

        suryaLightSlider.valueProperty().addListener((obs, oldVal, newVal) ->
                lightValueLabel.setText("Current Brightness: " + newVal.intValue() + "%"));
    }

    private List<Path> detectFanPaths() {
        List<Path> paths = new ArrayList<>();
        try (DirectoryStream<Path> stream = Files.newDirectoryStream(Paths.get("/sys/devices/platform/hp-wmi/hwmon/"), "hwmon*")) {
            for (Path hwmon : stream) {
                int i = 1;
                while (Files.exists(hwmon.resolve("fan" + i + "_target"))) {
                    paths.add(hwmon.resolve("fan" + i + "_target"));
                    i++;
                }
            }
        } catch (IOException e) {
            logger.error("Error detecting fan paths", e);
        }
        return paths;
    }

    private void applyFanSpeed(int index) {
        int speed = (int) fanSliders.get(index).getValue();
        Path fanPath = fanPaths.get(index);
        String command = "echo " + speed + " | sudo tee " + fanPath.toString();
        runCommandAsync(command,
                () -> {
                    fanLabels.get(index).setText("Applied Speed: " + speed + " RPM");
                    updateConfig("fan" + (index + 1), String.valueOf(speed));
                },
                () -> fanLabels.get(index).setText("Error applying fan speed"));
    }

    @FXML
    private void onApplyLightClick() {
        int brightness = (int) suryaLightSlider.getValue();
        String command = "echo " + brightness + " | sudo tee /sys/class/leds/hp::kbd_backlight/brightness";
        runCommandAsync(command,
                () -> {
                    lightValueLabel.setText("Applied Brightness: " + brightness + "%");
                    updateConfig("kbd_light", String.valueOf(brightness));
                },
                () -> lightValueLabel.setText("Error applying brightness"));
    }

    @FXML
    private void onSetLightClick() {
        Color color = colorPicker.getValue();
        int r = (int) (color.getRed() * 255);
        int g = (int) (color.getGreen() * 255);
        int b = (int) (color.getBlue() * 255);
        String command = String.format("echo \"%d %d %d\" | sudo tee /sys/class/leds/hp::kbd_backlight/multi_intensity", r, g, b);
        runCommandAsync(command,
                () -> {
                    logger.info("RGB Applied: " + r + " " + g + " " + b);
                    updateConfig("kbd_color", r + "," + g + "," + b);
                },
                () -> logger.error("Error applying RGB"));
    }

    private void runCommandAsync(String command, Runnable onSuccess, Runnable onError) {
        new Thread(() -> {
            try {
                ProcessBuilder pb = new ProcessBuilder("bash", "-c", command);
                Process process = pb.start();
                int exitCode = process.waitFor();
                Platform.runLater(() -> {
                    if (exitCode == 0) onSuccess.run();
                    else onError.run();
                });
            } catch (Exception e) {
                Platform.runLater(onError);
                logger.error("Error running command: {}", command, e);
            }
        }).start();
    }

    private void updateConfig(String key, String value) {
        try {
            Properties props = new Properties();
            if (Files.exists(CONFIG_PATH)) {
                try {
                    props.load(Files.newBufferedReader(CONFIG_PATH));
                } catch (IOException ignored) {}
            } else {
                Files.createDirectories(CONFIG_PATH.getParent());
                Files.createFile(CONFIG_PATH);
            }
            props.setProperty(key, value);
            props.store(Files.newBufferedWriter(CONFIG_PATH), "Updated by FanAndKeyboardController");
        } catch (IOException e) {
            logger.error("Error updating config file", e);
        }
    }
}
