package ru.vasiliy.phonebook.interfaces;

import ru.vasiliy.phonebook.objects.Person;

public interface PhoneBook {

    void add (Person person);
    void change ();
    void delete (Person person);
}
