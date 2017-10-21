package ru.vasiliy.phonebook.objects;

public class Person {
    private String familiya;
    private String imya;
    private String otchestvo;
    private String phone;

    public Person(String familiya, String imya, String otchestvo, String phone) {
        this.familiya = familiya;
        this.imya = imya;
        this.otchestvo = otchestvo;
        this.phone = phone;
    }

    public String getFamiliya() {
        return familiya;
    }

    public void setFamiliya(String familiya) {
        this.familiya = familiya;
    }

    public String getImya() {
        return imya;
    }

    public void setImya(String imya) {
        this.imya = imya;
    }

    public String getOtchestvo() {
        return otchestvo;
    }

    public void setOtchestvo(String otchestvo) {
        this.otchestvo = otchestvo;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
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
