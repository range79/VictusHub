package com.example.victusHub;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.List;

public class FanController {

    private final Logger logger = LoggerFactory.getLogger(FanController.class);
    private final FanCounter fanCounter = new FanCounter();

    @FXML
    private VBox fanContainer;
    private final List<Slider> fanSliders = new ArrayList<>();
    private final List<Label> fanLabels = new ArrayList<>();

    @FXML
    private Slider suryaLightSlider;
    @FXML
    private Label lightValueLabel;

    @FXML
    private ColorPicker colorPicker;


    @FXML
    private void initialize() {
        int fanCount = fanCounter.detectFanCount();
        for (int i = 0; i < fanCount; i++) {
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

    private void applyFanSpeed(int index) {
        int speed = (int) fanSliders.get(index).getValue();
        String command = "echo " + speed + " | sudo tee /sys/devices/platform/hp-wmi/hwmon/hwmon*/fan1_target";
        runCommandAsync(command,
                () -> fanLabels.get(index).setText("Applied Speed: " + speed + " RPM"),
                () -> fanLabels.get(index).setText("Error applying fan speed"));
    }

    @FXML
    private void onApplyLightClick() {
        int brightness = (int) suryaLightSlider.getValue();
        String command = "echo " + brightness + " | sudo tee /sys/class/leds/hp::kbd_backlight/brightness";
        runCommandAsync(command,
                () -> lightValueLabel.setText("Applied Brightness: " + brightness + "%"),
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
                () -> logger.info("RGB Applied: " + r + " " + g + " " + b) ,
                () ->logger.error("Error applying RGB")
        );

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
}
