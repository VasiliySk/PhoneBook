package ru.vasiliy.phonebook.start;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import ru.vasiliy.phonebook.interfaces.impls.CollectionPhoneBook;
import ru.vasiliy.phonebook.objects.Person;

public class Main extends Application {

    private CollectionPhoneBook collectionPhoneBook = new CollectionPhoneBook();

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("../fxml/main.fxml"));
        primaryStage.setTitle("Телефонный справочник");
        primaryStage.setMinWidth(640);
        primaryStage.setMinHeight(480);
        primaryStage.setScene(new Scene(root, 640, 480));
        primaryStage.show();
        collectionPhoneBook.fillData();
        collectionPhoneBook.printData();
    }
       
    public static void main(String[] args) {
        launch(args);
    }
    

    
}

