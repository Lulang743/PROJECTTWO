package com.example.project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
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

public class issuePrescription implements Initializable {

    @FXML
    private TableColumn<addDrugModelTable, String> prescriptionArea;

    @FXML
    private TableColumn<addDrugModelTable, String> prescriptionCategory;

    @FXML
    private TableColumn<addDrugModelTable, String> prescriptionDate;

    @FXML
    private TableColumn<addDrugModelTable, String> prescriptionID;

    @FXML
    private TableColumn<addDrugModelTable, String> prescriptionName;

    @FXML
    private TableColumn<addDrugModelTable, String> prescriptionQuantity;

    @FXML
    private TableColumn<addDrugModelTable, String> prescriptionSubstance;

    @FXML
    private TableView<addDrugModelTable> prescriptionTableVie;
    @FXML
    private TableColumn<addDrugModelTable, String> prescriptinSafety;
    @FXML
    private Label timeLabel;

    public issuePrescription() {
    }

    @FXML
    void mainMenu(MouseEvent event) {
        try {
            Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("dBoard.fxml")));
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
    void refreshButton(MouseEvent event) {


    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        ObservableList<addDrugModelTable> drugs= FXCollections.observableArrayList();
        DBConnection connection1 = new DBConnection();
        Connection conn = connection1.connect_to_db("pharmaceutical_company", "postgres", "12345");

        PreparedStatement preparedStatement1= null;
        try {
            preparedStatement1 = conn.prepareStatement("select * from add_drugs");
            ResultSet resultSet= preparedStatement1.executeQuery();
            while(resultSet.next()){
                drugs.add(new addDrugModelTable(
                        resultSet.getString("drugname"),
                        resultSet.getString("drugid"),
                        resultSet.getString("category"),
                        resultSet.getString("therapyarea"),
                        resultSet.getString("activesubstance"),
                        resultSet.getString("quantity"),
                        resultSet.getString("quantitysize"),
                        resultSet.getString("patientsafety"),
                        resultSet.getString("prod_date"),
                        resultSet.getString("expirydate"),
                        resultSet.getString("addeddate")));
            }
            prescriptionName.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("patient_safety"));
            prescriptionID.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_name"));
            prescriptionCategory.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_id"));
            prescriptionArea.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_category"));
            prescriptionSubstance.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_therapy_area"));
            prescriptionQuantity.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_activeSubstance"));
            prescriptinSafety.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_quantity"));
            prescriptionDate.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_add_date"));

            prescriptionTableVie.setItems(drugs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        /********
         * displaying time on the stage
         */
        Calendar calendar = null;
        SimpleDateFormat timeformat = new SimpleDateFormat("dd/MM/yyyy \nhh:mm:ss a");

        String time = timeformat.format(calendar.getInstance().getTime());
        timeLabel.setText(time);


    }
}
