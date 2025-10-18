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

    @FXML
    private VBox fanContainer;

    @FXML
    private Slider suryaLightSlider;
    @FXML
    private Label lightValueLabel;

    @FXML
    private ColorPicker colorPicker;

    private FanController fanController;
    private List<FanController.Fan> fans;

    private static final Path CONFIG_PATH = Path.of(System.getProperty("user.home"), ".config/victusservice/victus.config");

    @FXML
    private void initialize() {
        fanController = new FanController();
        fans = fanController.getFans();

        // Fan UI
        for (int i = 0; i < fans.size(); i++) {
            FanController.Fan fan = fans.get(i);
            TitledPane pane = createFanPane(fan, i);
            fanContainer.getChildren().add(pane);
        }

        // Keyboard light slider
        suryaLightSlider.valueProperty().addListener((obs, oldVal, newVal) ->
                lightValueLabel.setText("Current Brightness: " + newVal.intValue() + "%"));
    }

    private TitledPane createFanPane(FanController.Fan fan, int index) {
        VBox content = new VBox(10);

        Label label = new Label(fan.toString());

        Slider slider = new Slider(0, fan.getMaxRpm(), fan.getMaxRpm() / 2.0);
        slider.setShowTickLabels(true);
        slider.setShowTickMarks(true);

        Button applyButton = new Button("Apply Speed");
        applyButton.setOnAction(e -> {
            fan.setSpeed((int) slider.getValue());
            label.setText("Applied Speed: " + (int) slider.getValue());
            updateConfig("fan" + (index + 1), String.valueOf((int) slider.getValue()));
        });

        Button autoButton = new Button("Auto Mode");
        autoButton.setOnAction(e -> {
            fan.setAutoMode();
            label.setText("Auto Mode Enabled");
            updateConfig("fan" + (index + 1), "auto");
        });

        content.getChildren().addAll(label, slider, applyButton, autoButton);

        TitledPane pane = new TitledPane("Fan " + (index + 1), content);
        pane.setCollapsible(false);
        return pane;
    }

    @FXML
    private void onApplyLightClick() {
        int brightness = (int) suryaLightSlider.getValue();
        String cmd = "echo " + brightness + " | sudo tee /sys/class/leds/hp::kbd_backlight/brightness";
        runCommandAsync(cmd,
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

        String cmd = String.format("echo \"%d %d %d\" | sudo tee /sys/class/leds/hp::kbd_backlight/multi_intensity", r, g, b);
        runCommandAsync(cmd,
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
                try { props.load(Files.newBufferedReader(CONFIG_PATH)); } catch (IOException ignored) {}
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
