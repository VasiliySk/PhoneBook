package ru.vasiliy.phonebook.controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import ru.vasiliy.phonebook.interfaces.impls.CollectionPhoneBook;
import ru.vasiliy.phonebook.objects.Person;

import java.util.Optional;

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
                if(txtFam.getText().equals("")||txtNam.getText().equals("")||txtOtch.getText().equals("")||txtPho.getText().equals("")){

                    Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                    alert.setTitle("Подтверждение");
                    alert.setHeaderText(null);
                    alert.setContentText("Не все поля заполнены. Сохранить запись?");

                    Optional<ButtonType> result = alert.showAndWait();
                    if (result.get() == ButtonType.OK){
                        personSave();
                        ctnPhoneBook.add(person);
                        actionClose(actionEvent);
                        break;
                    } else {
                        break;
                    }
                }else {
                    personSave();
                    ctnPhoneBook.add(person);
                    actionClose(actionEvent);
                    break;
                }
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
