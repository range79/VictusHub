package com.example.victusHub;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class VictusHub extends Application {
    public VictusHub() {

    }
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(VictusHub.class.getResource("hello-view.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 700, 1000);
        stage.setTitle("Victus Hub");
        stage.setScene(scene);
        stage.show();
    }
}
