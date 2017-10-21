package ru.vasiliy.phonebook.interfaces.impls;

import ru.vasiliy.phonebook.interfaces.PhoneBook;
import ru.vasiliy.phonebook.objects.Person;

import java.util.ArrayList;

public class CollectionPhoneBook implements PhoneBook {

    private ArrayList<Person> personList = new ArrayList<Person>();

    @Override
    public void add(Person person) {
        getPersonList().add(person);
    }

    @Override
    public void change(Person person) {

    }

    @Override
    public void delete(Person person) {
        getPersonList().remove(person);
    }


    public ArrayList<Person> getPersonList() {
        return personList;
    }

    public void fillData(){

        personList.add(new Person("Ivanov","Ivan","Ivanovich","111123"));
        personList.add(new Person("Petrov","Petr","Stepanovich","1531581358"));
        personList.add(new Person("Sidorov","Sergey","Kirillovich","15358321"));

    }

    public void printData(){

        for (int i = 0; i < personList.size(); i++){

            System.out.println(personList.get(i).toString());
        }

    }
}
