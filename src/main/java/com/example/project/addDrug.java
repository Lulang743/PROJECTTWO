package com.example.project;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Calendar;
import java.util.Objects;
import java.util.ResourceBundle;

public class addDrug implements Initializable {

    @FXML
    private TextField addDruId;
    @FXML
    private Label timelabel;
    @FXML
    private ChoiceBox<String> addDrugCategory;
    @FXML
    private Label userNameLabel;

    @FXML
    private TextField addDrugActiveSubstance;


    @FXML
    private TextField addDrugName;

    @FXML
    private TextField addDrugQuantity;

    @FXML
    private TextField addDrugTherapyArea;

    @FXML
    private DatePicker myDatePicker;
    @FXML
    private ChoiceBox<String> myChoiceBx;
    @FXML
    private ChoiceBox<String> drugQuantityChoice;

    @FXML
    private TableColumn<addDrugModelTable, String> drugAreaColumn;

    @FXML
    private TableColumn<addDrugModelTable, String> drugCategoryColumn;

    @FXML
    private TableColumn<addDrugModelTable, String> drugColumnName;

    @FXML
    private TableColumn<addDrugModelTable, String> drugDateColumn;

    @FXML
    private TableColumn<addDrugModelTable, String> drugColumnPatientSafety;

    @FXML
    private TableColumn<addDrugModelTable, String> drugIdColomn;

    @FXML
    private TextField drugQuantitySize;

    @FXML
    private TableColumn<addDrugModelTable, String> drugQuantityColumn;

    @FXML
    private TableColumn<addDrugModelTable, String> drugSubstanceColumn;
    @FXML
    private TableColumn<addDrugModelTable, String> drugQuantityColumnUnits;


    @FXML
    private TableView<addDrugModelTable> drugTableview;
    @FXML
    private DatePicker myDatePicker1;
    String []choices={"Yes","No"};

    String[] drugCategories={"Cardiovascular","central nervous system",
            "Oral disease and conditions","Ear Nose and Throat disorders",
            "Endocrine conditions","Eye conditions","castro-intestinal",
            "Paediatric conditions", "Musculoskeletal conditions",
            "nutritional conditions","Psychiatric conditions",
            "Rental and urinary tract conditions ","skin conditions","Injuries and trauma",
            "Blood and Blood forming organs diseases","pain management"};
    String[] quantities={"kg","g","Ml",};

    public void mainMenu(MouseEvent event) {

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
    ObservableList<addDrugModelTable> drugs= FXCollections.observableArrayList();
/***********
 ******** function to switch display to the login page
 * *****************/


    public void signIn(MouseEvent event) {
        Parent root;
        try {
            FXMLLoader loader= new FXMLLoader((getClass().getResource("login.fxml")));
            root=loader.load();
            Stage stage13 = (Stage) ((Node) event.getSource()).getScene().getWindow();
            Scene scene = new Scene(root);
            stage13.setScene(scene);
            stage13.setFullScreen(true);
            stage13.show();
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

    public void addDrugList(MouseEvent mouseEvent) {

        String drugName = addDrugName.getText();

        String drugDrugId = addDruId.getText();

        //String drugCategory = addDrugCategory.getText();

        String drugArea = addDrugTherapyArea.getText();

        String drugSubstance = addDrugActiveSubstance.getText();


        LocalDate myDate=myDatePicker.getValue();
        LocalDate expDate=myDatePicker1.getValue();

        String productionDate= String.valueOf(myDatePicker.getValue());

        String expiryDate= String.valueOf(myDatePicker1.getValue());
        String category= String.valueOf(addDrugCategory.getItems().addAll(drugCategories));

        String quantity=drugQuantitySize.getText();
        String qSize=drugQuantitySize.getText();

/*****
 * **SETTING CURRENT DATE TO BE ADDED TO THE DATABASE
 * *****/
        Calendar calendar = null;
        SimpleDateFormat timeFormat = new SimpleDateFormat("dd-MM-yyyy ");
        String date = timeFormat.format(calendar.getInstance().getTime());


        String patientSafety=myChoiceBx.getValue();

        if (drugName.isEmpty() || !drugName.matches("[A-Za-z0-9]+")) {
            Alert user = new Alert(Alert.AlertType.WARNING);
            user.setTitle("Waarning Message");
            user.setHeaderText("Error");
            user.setContentText("please provide correct format for drug name...");
            user.show();
            ;

        } else if (drugDrugId.isEmpty() || !drugDrugId.matches("[A-Za-z0-9]+")) {
            Alert user = new Alert(Alert.AlertType.WARNING);
            user.setTitle("Waarning Message");
            user.setHeaderText("Error");
            user.setContentText("please provide correct format for drug ID...");
            user.show();
            ;

        }  else if (drugArea.isEmpty() || !drugArea.matches("[A-Za-z0-9]+")) {
            Alert user = new Alert(Alert.AlertType.WARNING);
            user.setTitle("Waarning Message");
            user.setHeaderText("Error");
            user.setContentText("please provide correct format for drug therapy area...");
            user.show();
            ;

        } else if (drugSubstance.isEmpty() || !drugSubstance.matches("[A-Za-z0-9]+")) {
            Alert user = new Alert(Alert.AlertType.WARNING);
            user.setTitle("Waarning Message");
            user.setHeaderText("Error");
            user.setContentText("please provide correct format for drug active substance...");
            user.show();
            ;

        } else if (qSize.isEmpty() || !qSize.matches("[A-Za-z0-9]+")) {
            Alert user = new Alert(Alert.AlertType.WARNING);
            user.setTitle("Waarning Message");
            user.setHeaderText("Error");
            user.setContentText("please provide correct format for drug quantity..");
            user.show();
            ;

        }else {
            DBConnection connection1 = new DBConnection();
            Connection conn = connection1.connect_to_db("pharmaceutical_company", "postgres", "12345");

            System.out.print(myDate);
            userNameLabel.setText(patientSafety);

            System.out.print(patientSafety);

            try {
                PreparedStatement preparedStatement=conn.prepareStatement("insert into add_drugs(drugname,drugid," +
                        "category,therapyarea,activesubstance," +
                        "quantitysize,quantityunits,patientsafety, prod_date,expirydate,addeddate)values(?,?,?,?,?,?,?,?,?,?,?)");
                preparedStatement.setString(1,drugName);
                preparedStatement.setString(2,drugDrugId);
                preparedStatement.setString(3,category);
                preparedStatement.setString(4,drugArea);
                preparedStatement.setString(5,drugSubstance);
                preparedStatement.setInt(6, Integer.parseInt(quantity));
                preparedStatement.setString(7,qSize);
                preparedStatement.setString(8,patientSafety);
                preparedStatement.setDate(9, Date.valueOf(productionDate));
                preparedStatement.setDate(10, Date.valueOf(expiryDate));
                preparedStatement.setDate(11, Date.valueOf(date));
                preparedStatement.executeUpdate();

                Alert user = new Alert(Alert.AlertType.WARNING);
                user.setTitle("CONFIRMATIONe");
                user.setHeaderText("Lo");
                user.setContentText("Drug added successfully to the database  ....");
                user.show();

                /*****display information on the table****/
                /*PreparedStatement preparedStatement1=conn.prepareStatement("select * from add_drugs");

                ResultSet resultSet= preparedStatement1.executeQuery();
                while(resultSet.next()){
                    drugs.add(new addDrugModelTable(
                            resultSet.getString("drugname"),
                            resultSet.getString("drugid"),
                            resultSet.getString("category"),
                            resultSet.getString("therapyarea"),
                            resultSet.getString("activesubstance"),
                            resultSet.getString("quantitysize"),
                            resultSet.getString("patientsafety"),
                            resultSet.getString("prod_date"),
                            resultSet.getString("expirydate"),
                            resultSet.getString("addeddate")));
                }
                drugColumnName.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_name"));
                drugIdColomn.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_id"));
                drugCategoryColumn.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_category"));
                drugAreaColumn.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_therapy_area"));
                drugSubstanceColumn.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_activeSubstance"));
                drugQuantityColumn.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_quantity"));
                drugColumnPatientSafety.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("patient_safety"));
                drugDateColumn.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_add_date"));

                drugTableview.setItems(drugs);*/



            } catch (SQLException e) {
                throw new RuntimeException(e);
            }

        }
    }
    @FXML
    void getExpDatePicker(ActionEvent event) {
        LocalDate mydate= myDatePicker.getValue();
        System.out.print(mydate);

    }

    @FXML
    void getProdDatePicker(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        /*************
         * displaying username
         */
        Parent root,root1;
        FXMLLoader loader= new FXMLLoader(getClass().getResource("dBoard.fxml"));
        FXMLLoader loader2= new FXMLLoader(getClass().getResource("login.fxml"));
        try {

            login log = new login();
            root= loader.load();
            root1=loader2.load();
            DBoard dispaly_name=loader.getController();
            login names=loader2.getController();
            dispaly_name.dispalayUsername(names.username);


        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        myChoiceBx.getItems().addAll(choices);
        addDrugCategory.getItems().addAll(drugCategories);
        drugQuantityChoice.getItems().addAll(quantities);
        DBConnection connection1 = new DBConnection();
        Connection conn = connection1.connect_to_db("pharmaceutical_company", "postgres", "12345");

       /* PreparedStatement preparedStatement1= null;
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
                        resultSet.getStrin3.g("prod_date"),
                        resultSet.getString("expirydate"),
                        resultSet.getString("addeddate")));
            }
            drugColumnName.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("patient_safety"));
            drugIdColomn.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_name"));
            drugCategoryColumn.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_id"));
            drugAreaColumn.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_category"));
            drugSubstanceColumn.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_therapy_area"));
            drugQuantityColumn.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_activeSubstance"));
            drugColumnPatientSafety.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_quantity"));
            drugQuantityColumnUnits.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_quantitySize"));
            drugDateColumn.setCellValueFactory( new PropertyValueFactory<addDrugModelTable,String>("drug_add_date"));

            drugTableview.setItems(drugs);

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }*/
        /********
         * displaying time on the stage
         */
        Calendar calendar = null;
        SimpleDateFormat timeformat = new SimpleDateFormat("dd/MM/yyyy \nhh:mm:ss a");

        String time = timeformat.format(calendar.getInstance().getTime());
        timelabel.setText(time);


    }
}
