package com.range.victusHub;

import javafx.application.Application;

import java.util.logging.Logger;

public class Launcher {

    private static final Logger log = Logger.getLogger("Launcher");

    public static void main(String[] args) {
        log.info("Application Started");
        Application.launch(VictusHub.class, args);
    }
}
