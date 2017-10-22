package ru.vasiliy.phonebook.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.vasiliy.phonebook.objects.Person;

public class DialogController {
    @FXML
    private TextField txtFam;
    @FXML
    private TextField txtNam;
    @FXML
    private TextField txtOtch;
    @FXML
    private TextField txtPho;
    @FXML
    private Button btnOk;
    @FXML
    private Button btnCancel;

    private Person person;

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage =(Stage)source.getScene().getWindow();
        stage.close();
    }

    public void setPerson(Person person){
        this.person =person;
        txtFam.setText(person.getFamiliya());
        txtNam.setText(person.getImya());
        txtOtch.setText(person.getOtchestvo());
        txtPho.setText(person.getPhone());
    }
}
