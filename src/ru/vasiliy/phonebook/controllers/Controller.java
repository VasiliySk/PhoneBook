package ru.vasiliy.phonebook.controllers;

import javafx.collections.ListChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Modality;
import javafx.stage.Stage;
import ru.vasiliy.phonebook.interfaces.impls.CollectionPhoneBook;
import ru.vasiliy.phonebook.objects.Person;

import java.io.IOException;


public class Controller {

    private CollectionPhoneBook collectionPhoneBook = new CollectionPhoneBook();

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
    private TableColumn <Person, String>tbcFamily;
    @FXML
    private TableColumn <Person, String>tbcName;
    @FXML
    private TableColumn <Person, String>tbcOtchestvo;
    @FXML
    private TableColumn <Person, String>tbcPhone;
    @FXML
    private Label lblCount;

    @FXML
    private void initialize(){
        tbcFamily.setCellValueFactory(new PropertyValueFactory<Person,String>("familiya"));
        tbcName.setCellValueFactory(new PropertyValueFactory<Person,String>("imya"));
        tbcOtchestvo.setCellValueFactory(new PropertyValueFactory<Person,String>("otchestvo"));
        tbcPhone.setCellValueFactory(new PropertyValueFactory<Person,String>("phone"));

        collectionPhoneBook.getPersonList().addListener((ListChangeListener) (c) ->{
            updateCountList();
        });

        collectionPhoneBook.fillData();
        tblTableView.setItems(collectionPhoneBook.getPersonList());

    }

    private void updateCountList(){
        lblCount.setText("Количесто записей: "+collectionPhoneBook.getPersonList().size());
    }

    public void showDialog(ActionEvent actionEvent){

        Object source = actionEvent.getSource();

        if (!(source instanceof Button)){
            return;
        }

        Button clickedButton =(Button)source;
        Person selectedPerson = (Person)tblTableView.getSelectionModel().getSelectedItem();

        switch (clickedButton.getId()){
            case "btnAdd":
                System.out.println("Add "+selectedPerson);
                break;
            case "btnChange":
                System.out.println("Change "+selectedPerson);
                break;
            case "btnDelete":
                System.out.println("Delete "+selectedPerson);
                break;
        }

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
