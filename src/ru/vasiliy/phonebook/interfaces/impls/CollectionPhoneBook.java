package ru.vasiliy.phonebook.interfaces.impls;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import ru.vasiliy.phonebook.interfaces.PhoneBook;
import ru.vasiliy.phonebook.objects.Person;

import java.io.*;

public class CollectionPhoneBook implements PhoneBook {

    private ObservableList<Person> personList = FXCollections.observableArrayList();

    @Override
    public void add(Person person) {
        getPersonList().add(person);
    }

    @Override
    public void change() {
        try(FileWriter writer = new FileWriter("database.txt"))
        {
            // запись всей строки
            for (int i=0;i<personList.size();i++){
                String text = personList.get(i).toString()+"\n";
                writer.write(text);
                // запись по символам
                //writer.append('\n');
                writer.flush();
            }
        }
        catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Person person) {
        getPersonList().remove(person);
    }


    public ObservableList<Person> getPersonList() {
        return personList;
    }

    public void loadFile(){

        try {
            File file = new File("database.txt");
            //создаем объект FileReader для объекта File
            FileReader fr = new FileReader(file);
            //создаем BufferedReader с существующего FileReader для построчного считывания
            BufferedReader reader = new BufferedReader(fr);
            // считаем сначала первую строку
            String line = reader.readLine();
            while (line != null) {
                String str = line;
                String[] words = str.split(";"); // Разбиение строки на слова с помощью разграничиля ";"
                Person person = new Person();
                for(int i=0;i<words.length;i++) {
                    switch (i){
                        case 0:
                            person.setFamiliya(words[i]);
                            break;
                        case 1:
                            person.setImya(words[i]);
                            break;
                        case 2:
                            person.setOtchestvo(words[i]);
                            break;
                        case 3:
                            person.setPhone(words[i]);
                            break;
                    }
                    //System.out.println(words[i]);
                }
                personList.add(person);
                // считываем остальные строки в цикле
                line = reader.readLine();
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
