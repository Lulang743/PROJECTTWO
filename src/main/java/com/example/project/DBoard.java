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
import javafx.scene.chart.BarChart;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class DBoard implements Initializable {

    @FXML
    private BarChart<String, Integer> BarChart;

    @FXML
    public Label adminAccount;

    @FXML
    private PieChart pieChart;

    @FXML
    void addDrugs(MouseEvent event) {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("drugsMenu.fxml")));
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
    void showChartsData(ActionEvent event) {

    }
    @FXML
    void signIn(MouseEvent event) {

        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("login.fxml")));
            Stage staged = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            staged.setScene(scene);
            staged.setFullScreen(true);
            staged.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
    public void dispalayUsername(String name){
        adminAccount.setText(name);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {


        ObservableList<PieChart.Data> pieChartData= FXCollections.observableArrayList(
                new PieChart.Data("HEADACHE",210),
                new PieChart.Data("HIGHBLOOD PRESSURE",50),
                new PieChart.Data("FLLUE",90));

        pieChartData.forEach(data -> data.nameProperty().bind(
                        Bindings.concat(
                                data.getName()," ",data.pieValueProperty()
                        )
                )
        );

        pieChart.getData().addAll( pieChartData);

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


        BarChart.getData().addAll(bars,bars2);


    }
    @FXML
    void switchToAccounts(MouseEvent event) {
        try {
            Parent openscene = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("AccountsPage.fxml")));
            Stage stageAccounts = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(openscene);
            stageAccounts.setScene(scene);
            stageAccounts.setFullScreen(true);
            stageAccounts.show();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }
}
