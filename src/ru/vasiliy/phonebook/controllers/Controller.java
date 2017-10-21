package ru.vasiliy.phonebook.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Modality;
import javafx.stage.Stage;

import java.io.IOException;


public class Controller {
    @FXML
    private Button btnAdd;
    @FXML
    private Button btnChange;
    @FXML
    private Button btnDelete;
    @FXML
    private TextField txtSearch;
    @FXML
    private Button btnSearch;
    @FXML
    private TableView tblTableView;
    @FXML
    private TableColumn tbcFamily;
    @FXML
    private TableColumn tbnName;
    @FXML
    private TableColumn tbnOtchestvo;
    @FXML
    private TableColumn tbnPhone;
    @FXML
    private Label lblCount;

    public void showDialog(ActionEvent actionEvent){
        try {
            Stage stage = new Stage();
            Parent root = FXMLLoader.load(getClass().getResource("../fxml/dialog.fxml"));
            stage.setTitle("Модальное окно");
            stage.setMinWidth(150);
            stage.setMinWidth(200);
            stage.setResizable(false);
            stage.setScene(new Scene(root));
            stage.initModality(Modality.WINDOW_MODAL);
            stage.initOwner(((Node)actionEvent.getSource()).getScene().getWindow());
            stage.show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

}
