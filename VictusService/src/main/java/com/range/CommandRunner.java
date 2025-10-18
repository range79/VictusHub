package com.range;

import java.io.IOException;

public class CommandRunner
{
    public static void runCommandAsync(String command) throws IOException {

                ProcessBuilder pb = new ProcessBuilder("bash", "-c", command);
                Process process = pb.start();
        System.out.printf("Failed to run command: %s\n", command);
    }

    }

