package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;

public class AccountsPage {
    @FXML
    private ImageView closeImage;
    @FXML
    void closeWindow(MouseEvent event) {
        Stage stage = (Stage) closeImage.getScene().getWindow();
        stage.close();

    }

    @FXML
    void mainMenu(MouseEvent event) {
        Parent root;
        try {
            FXMLLoader loader= new FXMLLoader(getClass().getResource("dBoard.fxml"));
            root= loader.load();

            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();

        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
