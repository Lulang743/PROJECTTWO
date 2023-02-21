package com.example.project;

import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.*;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.ResourceBundle;

public class HelloController implements Initializable {
    @FXML
    private AnchorPane singButton;

    @FXML
    private LineChart<Double, String> lineChart;
    @FXML
    private TextField usernameTextfield;

    @FXML
    private PieChart pieChart;

    @FXML
    private StackedBarChart<String, Integer> stackBarChart;

    @FXML
    private BarChart<String, Integer> BarChart;

    @FXML
    private TextField registerUserIdTextfield;

    @FXML
    private PasswordField registerUserPassword;

    @FXML
    private TextField registerUserTypeTextfield;

    @FXML
    private TextField registerUsernamneTextfield;
    Parent root;




    @FXML
    void clearOnAccount(MouseEvent mouseEvent) {
        registerUsernamneTextfield.setText("");
        registerUserTypeTextfield.setText("");
        registerUserIdTextfield.setText("");
        registerUserPassword.setText("");

    }

    @FXML
    void register(MouseEvent event) {


        String name=registerUsernamneTextfield.getText();
        String userType=registerUserTypeTextfield.getText();
        String userIdm=registerUserIdTextfield.getText();
        String password=registerUserPassword.getText();


        if (name.isEmpty() || !name.matches("[A-Za-z0-9]+")) {
            Alert user = new Alert(Alert.AlertType.WARNING);
            user.setTitle("Waarning Message");
            user.setHeaderText("Error");
            user.setContentText("please provide correct format for username...");
            user.show();
            ;

        } else if (userType.isEmpty() || !userType.matches("[A-Za-z0-9]+")) {
            Alert user = new Alert(Alert.AlertType.WARNING);
            user.setTitle("Waarning Message");
            user.setHeaderText("Error");
            user.setContentText("please provide correct format for usertype...");
            user.show();
            ;

        } else if (userIdm.isEmpty() || !userIdm.matches("[0-9]+")) {
            Alert user = new Alert(Alert.AlertType.WARNING);
            user.setTitle("Waarning Message");
            user.setHeaderText("Error");
            user.setContentText("please provide correct format for userId...");
            user.show();
            ;

        } else if (password.isEmpty() || !password.matches("[A-Za-z0-9]+")) {
            Alert user = new Alert(Alert.AlertType.WARNING);
            user.setTitle("Waarning Message");
            user.setHeaderText("Error");
            user.setContentText("please provide correct format for password...");
            user.show();
            ;

        } else {

            DBConnection connection1= new DBConnection();
            Connection conn= connection1.connect_to_db("pharmaceutical_company","postgres","12345");

            try {
                PreparedStatement preparedStatement=conn.prepareStatement("insert into newuser(usertype,username,userID,password)values(?,?,?,?)");
                preparedStatement.setString(1,name);
                preparedStatement.setString(2,userType);
                preparedStatement.setString(3,userIdm);
                preparedStatement.setString(4,password);
                preparedStatement.executeUpdate();

                Alert user = new Alert(Alert.AlertType.WARNING);
                user.setTitle("CONFIRMATIONe");
                user.setHeaderText("Lo");
                user.setContentText("Registeration successful ....");
                user.show();


                try {
                    FXMLLoader loader= new FXMLLoader((getClass().getResource("login.fxml")));
                    root=loader.load();

                    Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.setFullScreen(true);
                    stage.show();

                    login controllerLogin=loader.getController();
                    controllerLogin.showTime();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }


        }

    }

    @FXML
    void signIn(MouseEvent event) {
        try {
            FXMLLoader loader= new FXMLLoader((getClass().getResource("login.fxml")));
            root=loader.load();
            Stage stageWindow = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stageWindow.setScene(scene);
            stageWindow.setFullScreen(true);
            stageWindow.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public void showTime(){
        Calendar calendar = null;
        SimpleDateFormat timeformat = new SimpleDateFormat("dd/MM/yyyy \nhh:mm:ss a");

        String time = timeformat.format(calendar.getInstance().getTime());
       // showTimeOnlock = new Label(time);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}