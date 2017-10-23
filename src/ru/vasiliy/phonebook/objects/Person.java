package ru.vasiliy.phonebook.objects;

import javafx.beans.property.SimpleStringProperty;

public class Person {
    private SimpleStringProperty familiya = new SimpleStringProperty("");
    private SimpleStringProperty imya = new SimpleStringProperty("");
    private SimpleStringProperty otchestvo=new SimpleStringProperty("");
    private SimpleStringProperty phone=new SimpleStringProperty("");

    public Person(){}

    public Person(String familiya, String imya, String otchestvo, String phone) {
        this.familiya = new SimpleStringProperty(familiya);
        this.imya = new SimpleStringProperty(imya);
        this.otchestvo = new SimpleStringProperty(otchestvo);
        this.phone = new SimpleStringProperty(phone);
    }

    public String getFamiliya() {
        return familiya.get();
    }

    public void setFamiliya(String familiya) {
        this.familiya.set( familiya);
    }

    public String getImya() {
        return imya.get();
    }

    public void setImya(String imya) {
        this.imya.set(imya);
    }

    public String getOtchestvo() {
        return otchestvo.get();
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo.set(otchestvo);
    }

    public String getPhone() {
        return phone.get();
    }

    public void setPhone(String phone) {
        this.phone.set(phone);
    }

    public SimpleStringProperty familiyaProperty() {
        return familiya;
    }

    public SimpleStringProperty imyaProperty() {
        return imya;
    }

    public SimpleStringProperty otchestvoProperty() {
        return otchestvo;
    }

    public SimpleStringProperty phoneProperty() {
        return phone;
    }

    @Override
    public String toString() {
        return "Person{" +
                "familiya='" + familiya + '\'' +
                ", imya='" + imya + '\'' +
                ", otchestvo='" + otchestvo + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
