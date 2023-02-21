package com.example.project;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Objects;
import java.util.ResourceBundle;

public class login implements Initializable {

    @FXML
    private PasswordField hidePassword;

    @FXML
    private AnchorPane singButton;

    @FXML
    private TextField usernameTextfield;

    @FXML
    private Label timeLabel;
    @FXML
    private ImageView closeImage;
    String password;
    String username;
    String uType;
    String[] users={"Admin","doctor","PHARMACIST","NURSE"};
    @FXML
    private TextField usertypeTextfield;




    @FXML
    void clearOnAccount(MouseEvent event) {
        username=usernameTextfield.getText();
        password=hidePassword.getText();
        usernameTextfield.setText("");
        hidePassword.setText("");
        usertypeTextfield.setText("");

    }
    @FXML
    void getUserType(MouseEvent event) {

    }

    @FXML
    void logIn(MouseEvent event) {
        username=usernameTextfield.getText();
        uType=usertypeTextfield.getText();
        password=hidePassword.getText();

        Parent root;
        DBConnection connection1= new DBConnection();
        Connection conn=connection1.connect_to_db("pharmaceutical_company","postgres","12345");

        if (username.isEmpty() || !username.matches("[A-Za-z0-9]+")) {
            Alert user = new Alert(Alert.AlertType.WARNING);
            user.setTitle("Waarning Message");
            user.setHeaderText("Error");
            user.setContentText("please provide correct format for username...");
            user.show();
            ;

        } else if (password.isEmpty() || !password.matches("[A-Za-z0-9]+")) {
            Alert user = new Alert(Alert.AlertType.WARNING);
            user.setTitle("Waarning Message");
            user.setHeaderText("Error");
            user.setContentText("please provide correct format for password...");
            user.show();
            ;

        } else if (uType.isEmpty() || !uType.matches("[A-Za-z0-9]+")) {
            Alert user = new Alert(Alert.AlertType.WARNING);
            user.setTitle("Waarning Message");
            user.setHeaderText("Error");
            user.setContentText("please provide correct format for user type...");
            user.show();
            ;

        } else {
            username.matches(".*([ \t]).*");
            password.matches(".*([ \t]).*");
            uType.matches(".*([ \t]).*");

            try {
                PreparedStatement preparedStatement = conn.prepareStatement("select * from newuser where username=? AND password=?AND usertype=?");
                preparedStatement.setString(1, username);
                preparedStatement.setString(2, uType);
                preparedStatement.setString(3, password);

                ResultSet result = preparedStatement.executeQuery();
                if (uType.equals("admin")||uType.equals("ADMIN")){
                    Alert user = new Alert(Alert.AlertType.WARNING);
                    user.setTitle("Error Alert");
                    user.setHeaderText("LOGIN");
                    user.setContentText("LOGIN SUCCESSFUL." + "WELCOME  " +uType.toUpperCase()+" "+ username.toUpperCase());
                    user.show();

                    /****
                     * calling dashbord for  admin
                     * *****/
                    try {
                        FXMLLoader loader= new FXMLLoader((getClass().getResource("dBoard.fxml")));
                        root=loader.load();
                        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
                        Scene scene = new Scene(root);
                        stage.setScene(scene);
                        stage.setFullScreen(true);
                        stage.show();
                    } catch (IOException e) {
                        throw new RuntimeException(e);
                    }

                } else if (uType.equals("doctor")||uType.equals("DOCTOR")||uType.equals("Doctor")) {
                    Alert user = new Alert(Alert.AlertType.WARNING);
                    user.setTitle("Error Alert");
                    user.setHeaderText("LOGIN");
                    user.setContentText("LOGIN SUCCESSFUL." + "WELCOME  " +uType.toUpperCase()+" "+ username.toUpperCase());
                    user.show();

                    try {
                        FXMLLoader loader= new FXMLLoader((getClass().getResource("doctorDashBord.fxml")));
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
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
    }
    public  void showUserNames(){

    }

    @FXML
    void signUp(MouseEvent event) {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
            Stage   stagelog = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stagelog.setScene(scene);
            stagelog.setFullScreen(true);
            stagelog.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        /********
         * displaying time on the stage
         */


        Calendar calendar = null;
        SimpleDateFormat timeformat = new SimpleDateFormat("dd/MM/yyyy \nhh:mm:ss a");

        String time = timeformat.format(calendar.getInstance().getTime());
        timeLabel.setText(time);

        /********
         * setting sigin button to be invisible
         * ****/

    }
    @FXML
    void closeWindow(MouseEvent event) {
        Stage stage = (Stage) closeImage.getScene().getWindow();
        stage.close();

    }
    public void showTime(){

        Calendar calendar = null;
        SimpleDateFormat timeformat = new SimpleDateFormat("dd/MM/yyyy \nhh:mm:ss a");
        String time = timeformat.format(calendar.getInstance().getTime());
        timeLabel= new Label(time);
        timeLabel.setText(time);
    }
}
