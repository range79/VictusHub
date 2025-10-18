package com.range;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Main {
    private static final Path CONFIG_PATH = Path.of(System.getProperty("user.home"), ".config/victusservice/victus.config");

    public static void main(String[] args) {
        try {
            if (Files.exists(CONFIG_PATH)) {
                List<String> lines = Files.readAllLines(CONFIG_PATH);
                Map<String, String> config = new HashMap<>();
                    for (String line : lines) {
                        line = line.trim();
                        if (line.isEmpty() || line.startsWith("#")) continue;
                        String[] parts = line.split("=", 2);
                        if (parts.length == 2) {
                            config.put(parts[0], parts[1]);
                        }
                    }

                int fanCount = 0;

                for (String key : config.keySet()) {
                    if (key.startsWith("fan")) {
                        fanCount++;
                    }
                }

                for (int i = 1; i <= fanCount; i++) {
                    int fanSpeed = Integer.parseInt(config.getOrDefault("fan" + i, "0"));
                    System.out.println("Fan " + i + " speed: " + fanSpeed);
                    String command = "echo " + fanSpeed + " | sudo tee /sys/devices/platform/hp-wmi/hwmon/hwmon*/fan" + i + "_target";
                    CommandRunner.runCommandAsync(command);
                }

                int kbdLight = Integer.parseInt(config.getOrDefault("kbd_light", "0"));
                System.out.println("Keyboard light: " + kbdLight);
                CommandRunner.runCommandAsync("echo " + kbdLight + " | sudo tee /sys/class/leds/hp::kbd_backlight/brightness");

                String kbdColor = config.getOrDefault("kbd_color", "0,0,0");
                System.out.println("Keyboard color: " + kbdColor);
                String[] rgb = kbdColor.split(",");
                if (rgb.length == 3) {
                    String command = String.format("echo \"%s %s %s\" | sudo tee /sys/class/leds/hp::kbd_backlight/multi_intensity", rgb[0], rgb[1], rgb[2]);
                    CommandRunner.runCommandAsync(command);
                }

            } else {
                System.err.println("Config file not found: " + CONFIG_PATH);
            }
        } catch (IOException e) {
            System.err.println("Error reading config file: " + e.getMessage());
        }
    }
}
