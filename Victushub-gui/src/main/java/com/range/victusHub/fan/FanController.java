package com.range.victusHub.fan;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class FanController {

    private static final String BASE_PATH = "/sys/devices/platform/hp-wmi/hwmon";
    private final List<Fan> fans = new ArrayList<>();

    public FanController() {
        detectFans();
    }

    private void detectFans() {
        File hwmonDir = new File(BASE_PATH);
        if (!hwmonDir.exists() || !hwmonDir.isDirectory()) return;

        File[] hwmons = hwmonDir.listFiles((dir, name) -> name.startsWith("hwmon"));
        if (hwmons == null) return;

        for (File hwmon : hwmons) {
            File[] fanTargets = hwmon.listFiles((dir, name) -> name.matches("fan\\d+_target"));
            if (fanTargets == null) continue;

            for (File fanFile : fanTargets) {
                String index = fanFile.getName().replaceAll("\\D+", "");
                File enableFile = new File(hwmon, "pwm" + index + "_enable");
                File maxFile = new File(hwmon, "fan" + index + "_max");

                int maxRpm = readInt(maxFile);
                fans.add(new Fan(Integer.parseInt(index), fanFile, enableFile, maxRpm));
            }
        }
    }

    public List<Fan> getFans() {
        return fans;
    }


    public void enableAutoModeAll() {
        for (Fan fan : fans) {
            fan.setAutoMode();
        }
    }


    public void enableManualModeAll() {
        for (Fan fan : fans) {
            fan.setManualMode();
        }
    }

    private int readInt(File file) {
        try (java.util.Scanner sc = new java.util.Scanner(file)) {
            return sc.nextInt();
        } catch (Exception e) {
            return 6000;
        }
    }

    public static class Fan {
        private final int index;
        private final File targetFile;
        private final File enableFile;
        private final int maxRpm;

        public Fan(int index, File targetFile, File enableFile, int maxRpm) {
            this.index = index;
            this.targetFile = targetFile;
            this.enableFile = enableFile;
            this.maxRpm = maxRpm;
        }

        public void setAutoMode() {
            write(enableFile, "2");
        }

        public void setManualMode() {
            write(enableFile, "1");
        }

        public void setSpeed(int rpm) {
            if (rpm > maxRpm) rpm = maxRpm;
            write(targetFile, String.valueOf(rpm));
        }

        public int getMaxRpm() {
            return maxRpm;
        }

        private void write(File file, String value) {
            try (FileWriter fw = new FileWriter(file)) {
                fw.write(value);
            } catch (IOException e) {
                System.err.println("Fan " + index + ": " + e.getMessage());
            }
        }

        @Override
        public String toString() {
            return "Fan " + index + " (max " + maxRpm + " rpm)";
        }
    }
}
