package com.example.victusHub;


import java.io.File;

public class FanCounter {

    public int detectFanCount() {
        File hwmonDir = new File("/sys/devices/platform/hp-wmi/hwmon/");
        if (!hwmonDir.exists() || !hwmonDir.isDirectory()) {
            return 0;
        }

        File[] hwmonFolders = hwmonDir.listFiles((dir, name) -> name.startsWith("hwmon"));
        int fanCount = 0;

        if (hwmonFolders != null) {
            for (File hwmon : hwmonFolders) {
                File[] fanFiles = hwmon.listFiles((dir, name) -> name.matches("fan\\d+_input"));
                if (fanFiles != null) {
                    fanCount += fanFiles.length;
                }
            }
        }

        return fanCount;
    }
}
