package ru.vasiliy.phonebook.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.vasiliy.phonebook.interfaces.impls.CollectionPhoneBook;
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

    private CollectionPhoneBook ctnPhoneBook;

    private String btn;

    public void actionClose(ActionEvent actionEvent) {
        Node source = (Node) actionEvent.getSource();
        Stage stage =(Stage)source.getScene().getWindow();
        stage.hide();
    }

    public void setPerson(Person person){
        this.person =person;
        txtFam.setText(person.getFamiliya());
        txtNam.setText(person.getImya());
        txtOtch.setText(person.getOtchestvo());
        txtPho.setText(person.getPhone());
    }

    public void setCtnPhoneBook(CollectionPhoneBook ctnPhoneBook) {
        this.ctnPhoneBook = ctnPhoneBook;
    }

    public void actionSave(ActionEvent actionEvent) {
        switch (btn) {
            case "btnChange":
                personSave();
                actionClose(actionEvent);
                break;
            case "btnDelete":
                ctnPhoneBook.delete(person);
                actionClose(actionEvent);
                break;
            case "btnAdd":
                personSave();
                ctnPhoneBook.add(person);
                actionClose(actionEvent);
                break;
        }
    }

    private void personSave() {
        person.setFamiliya(txtFam.getText());
        person.setImya(txtNam.getText());
        person.setOtchestvo(txtOtch.getText());
        person.setPhone(txtPho.getText());
    }

    public void setBtn(String btn) {
        this.btn = btn;
    }
}
