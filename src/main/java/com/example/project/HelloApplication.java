package com.example.project;

import javafx.animation.FadeTransition;
import javafx.application.Application;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;

import java.io.IOException;
import java.util.Objects;

public class HelloApplication extends Application {
    @FXML
    private AnchorPane parent;
    @Override
    public void start(Stage stage) throws IOException {

        FadeTransition fade= new FadeTransition();
        fade.setDuration(Duration.millis(5000));
        fade.setFromValue(10);
        fade.setToValue(0.1);
        fade.setCycleCount(1000);
        fade.setAutoReverse(true);

        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("Home.fxml"));
        Scene scene = new Scene(fxmlLoader.load());
        stage.setTitle("Hello!");

        stage.setScene(scene);
        stage.setFullScreen(true);
        stage.show();
    }

    public static void main(String[] args) {
        launch();
    }
}