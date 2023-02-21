package com.example.project;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DoctorDashBord implements Initializable {
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void LOGOUT(ActionEvent event) {
        Parent root;

        try {
            FXMLLoader loader= new FXMLLoader((getClass().getResource("Home.fxml")));
            root=loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void addPatient(ActionEvent event) {
        Parent root;

        try {
            FXMLLoader loader= new FXMLLoader((getClass().getResource("addPatient.fxml")));
            root=loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void addPrescription(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("issuePrescription.fxml")));
            Stage stage1 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage1.setScene(scene);
            stage1.setFullScreen(true);
            stage1.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void drugUsage(ActionEvent event) {

    }

    @FXML
    void notifications(ActionEvent event) {

    }

    @FXML
    void patientRecords(ActionEvent event) {
        Parent root;

        try {
            FXMLLoader loader= new FXMLLoader((getClass().getResource("patientRecord.fxml")));
            root=loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(true);
            stage.show();
        }
        catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void pharmacists(ActionEvent event) {

    }
}
