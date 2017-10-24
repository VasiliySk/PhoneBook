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
import javafx.scene.input.MouseEvent;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.Window;
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

    private Parent fxmlEdit;

    private FXMLLoader fxmlLoader =new FXMLLoader();

    private DialogController dialogController;

    private Stage dialogStage;

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

        try {
            fxmlLoader.setLocation(getClass().getResource("../fxml/dialog.fxml"));
            fxmlEdit = fxmlLoader.load();
            dialogController = fxmlLoader.getController();
        }catch (IOException e){
            e.printStackTrace();
        }

    }

    private void updateCountList(){
        lblCount.setText("Количесто записей: "+collectionPhoneBook.getPersonList().size());
    }

    private void showDialog(Window parentWindow, String title){

        if (dialogStage==null){
            dialogStage = new Stage();
            dialogStage.setMinWidth(150);
            dialogStage.setMinWidth(200);
            dialogStage.setResizable(false);
            dialogStage.setScene(new Scene(fxmlEdit));
            dialogStage.initModality(Modality.WINDOW_MODAL);
            dialogStage.initOwner(parentWindow);
        }

        dialogStage.setTitle(title);
        dialogStage.show();

    }

    public void actionButtonPressed(ActionEvent actionEvent) {

        Object source = actionEvent.getSource();

        if (!(source instanceof Button)){
            return;
        }

        Button clickedButton =(Button)source;
        Person selectedPerson = (Person)tblTableView.getSelectionModel().getSelectedItem();
        Window parentWindow = ((Node)actionEvent.getSource()).getScene().getWindow();

        switch (clickedButton.getId()){
            case "btnAdd":
                dialogController.setBtn("btnAdd");
                dialogController.setPerson(new Person());
                dialogController.setCtnPhoneBook(collectionPhoneBook);
                showDialog(parentWindow, "Добавление записи");
                break;
            case "btnChange":
                dialogController.setBtn("btnChange");
                dialogController.setPerson(selectedPerson);
                showDialog(parentWindow, "Изменение записи");
                break;
            case "btnDelete":
                dialogController.setBtn("btnDelete");
                dialogController.setPerson(selectedPerson);
                dialogController.setCtnPhoneBook(collectionPhoneBook);
                showDialog(parentWindow, "Удаление записи");
                break;
        }

    }

    public void doubleClicked(MouseEvent mouseEvent) {
        if (mouseEvent.getClickCount()==2){
            Person selectedPerson = (Person)tblTableView.getSelectionModel().getSelectedItem();
            Window parentWindow = ((Node)mouseEvent.getSource()).getScene().getWindow();
            dialogController.setBtn("btnChange");
            dialogController.setPerson(selectedPerson);
            showDialog(parentWindow, "Изменение записи");
        }
    }
}
