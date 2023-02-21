package com.example.project;

import javafx.application.Platform;
import javafx.beans.binding.Bindings;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.StackedBarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.DragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
//import javafx.scene.media.MediaView;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import javafx.scene.media.MediaView;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.ResourceBundle;

public class Home implements Initializable {
    @FXML
    private PieChart pieChartTwo;
    private volatile boolean stop =false;
    @FXML
    private ImageView closeImage;

    @FXML
    private Label timeLabel;
    @FXML
    private MediaView mediaViewV;
    private File file;
    private Media media;
    private MediaPlayer player;
    @FXML
    private AnchorPane parent;
    @FXML
    private Label addUsers;
    @FXML
    private StackedBarChart<String, Integer> stackBartChart;
    @FXML
    private Label homeButton;

    @FXML
    void addUsersClicked(MouseEvent event) {
        addUsers.setStyle("-fx-background-color:blue");

    }
    @FXML
    void homeButtonTouched(DragEvent event) {


    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        /****
         * ****setting video on the scene
         * ***/
        file= new File("Explanatory.mp4");
        media= new Media(file.toURI().toString());
        player= new MediaPlayer(media);
        mediaViewV.setMediaPlayer(player);
        player.play();



        /********
         * displaying time on the stage
         */

        Thread timethread= new Thread(()->{
            Calendar calendar = null;
           // String time = timeformat.format(calendar.getInstance().getTime());
            SimpleDateFormat timeformat= new SimpleDateFormat("HH:mm:ss");
            while (!stop){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                String time = timeformat.format(calendar.getInstance().getTime());
                Platform.runLater(()->{
                    timeLabel.setText(time);

                });
            }
        });
        timethread.start();


        /*ObservableList<PieChart.Data> pieChartData= FXCollections.observableArrayList(
                new PieChart.Data("HEADACHE",210),
                new PieChart.Data("HIGHBLOOD PRESSURE",50),
                new PieChart.Data("FLLUE",90));

        pieChartData.forEach(data -> data.nameProperty().bind(
                        Bindings.concat(
                                data.getName()," ",data.pieValueProperty()
                        )
                )
        );

        pieChartTwo.getData().addAll( pieChartData);
*/
        XYChart.Series<String,Integer> bars= new XYChart.Series<>();
        bars.setName("Bar chart");
        bars.getData().add(new XYChart.Data<>("MONDAY",200));
        bars.getData().add(new XYChart.Data<>("TUESDAY",280));
        bars.getData().add(new XYChart.Data<>("WEDNESDAY",100));
        bars.getData().add(new XYChart.Data<>("THURSDAY",400));
        bars.getData().add(new XYChart.Data<>("FRIDAY",150));

        XYChart.Series<String,Integer> bars2= new XYChart.Series<>();
        bars2.setName("Bar chart");
        bars2.getData().add(new XYChart.Data<>("MONDAY",2007));
        bars2.getData().add(new XYChart.Data<>("TUESDAY",2807));
        bars2.getData().add(new XYChart.Data<>("WEDNESDAY",1005));
        bars2.getData().add(new XYChart.Data<>("THURSDAY",4004));
        bars2.getData().add(new XYChart.Data<>("FRIDAY",1503));


       // stackBartChart.getData().addAll(bars,bars2);


    }

    @FXML
    void closeButton(MouseEvent event) {
        Stage stage = (Stage) closeImage.getScene().getWindow();
        stage.close();

    }

    @FXML
    void navigateToLogin(MouseEvent event) {

        /*******
         * ***PAUSING THE VIDEO
         * **/
        player.stop();

        Parent root;

        try {
            FXMLLoader loader= new FXMLLoader((getClass().getResource("login.fxml")));
            root=loader.load();
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setFullScreen(false);
            stage.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    @FXML
    void navigateToRegister(MouseEvent event) {

        player.stop();

        Parent root;
        try {
            FXMLLoader loader= new FXMLLoader((getClass().getResource("hello-view.fxml")));
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




}
