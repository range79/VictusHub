package com.example.victusHub;

import javafx.application.Application;
import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import java.util.stream.Collectors;

public class Launcher {

    private static final Logger LOG = Logger.getLogger("Launcher");

    public static void main(String[] args) throws InterruptedException {
        LOG.info("Launcher starting, performing minimal config check...");

        String binaryPath = args.length > 0 ? args[0] : "/usr/local/bin/victusHub";
        String sudoersName = args.length > 1 ? args[1] : "victusHub-" + System.getProperty("user.name");

        // Minimal config check
        ConfigCheckerMinimal.check(binaryPath, "/etc/sudoers.d/" + sudoersName);
        Thread.sleep(1000);
        // Start JavaFX application
        Application.launch(VictusHub.class, args);
    }

    /** Minimal config checker */
    public static class ConfigCheckerMinimal {
        public static void check(String binaryPath, String sudoersPath) {
            LOG.info("=== Config Check (Minimal) ===");
            checkBinary(binaryPath);
            checkSudoers(sudoersPath);
            checkGetcap(binaryPath);
            LOG.info("=== Config Check Completed ===");
        }

        private static void checkBinary(String pathStr) {
            Path path = Path.of(pathStr);
            if (!Files.exists(path)) {
                LOG.warning("Binary not found: " + pathStr);
                return;
            }
            File f = path.toFile();
            LOG.info("Binary found: " + f.getAbsolutePath());
            LOG.info(" - size: " + f.length() + " bytes");
            LOG.info(" - executable: " + f.canExecute());
            try {
                String perms = Files.getPosixFilePermissions(path).stream()
                        .map(Object::toString)
                        .collect(Collectors.joining(","));
                LOG.info(" - permissions: " + perms);
            } catch (Exception e) {
                LOG.fine("Unable to read permissions: " + e.getMessage());
            }
        }

        private static void checkSudoers(String sudoersPath) {
            Path path = Path.of(sudoersPath);
            if (!Files.exists(path)) {
                LOG.info("Sudoers fragment missing: " + sudoersPath);
                LOG.info(" -> To allow passwordless sudo (with user consent): echo \"<user> ALL=(root) NOPASSWD: <binary>\" | sudo tee " + sudoersPath);
                return;
            }
            LOG.info("Sudoers fragment exists: " + sudoersPath);
            runAndLog(List.of("sudo", "visudo", "-c", "-f", sudoersPath), "visudo validation");
        }

        private static void checkGetcap(String binaryPath) {
            runAndLog(List.of("which", "getcap"), "getcap check (is libcap installed?)");
            runAndLog(List.of("getcap", binaryPath), "getcap - binary capabilities");
        }

        private static void runAndLog(List<String> cmd, String desc) {
            try {
                ProcessBuilder pb = new ProcessBuilder(cmd);
                pb.redirectErrorStream(true);
                Process p = pb.start();
                try (BufferedReader br = new BufferedReader(new InputStreamReader(p.getInputStream()))) {
                    String out = br.lines().collect(Collectors.joining("\n"));
                    int rc = p.waitFor();
                    if (rc == 0) {
                        LOG.info(desc + " succeeded. Output: " + (out.isBlank() ? "<empty>" : out));
                    } else {
                        LOG.warning(desc + " failed (rc=" + rc + "). Output: " + (out.isBlank() ? "<empty>" : out));
                        if (out.toLowerCase().contains("sudo") || out.toLowerCase().contains("password")) {
                            LOG.warning(" -> Note: visudo/sudo commands may require root password; interactive terminal may be needed.");
                        }
                    }
                }
            } catch (Exception e) {
                LOG.log(Level.WARNING, desc + " could not run: " + e.getMessage(), e);
            }
        }
    }
}
