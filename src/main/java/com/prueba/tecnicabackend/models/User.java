package com.prueba.tecnicabackend.models;


public class User {

    private String firstName;
    private String middleName;
    private String firstLastName;
    private String secondLastName;
    private String phone;
    private String address;
    private String cityResidence;
    private int numberDoc;
    private String docType;

    public int getNumberDoc() {
        return numberDoc;
    }

    public void setNumberDoc(int numberDoc) {
        this.numberDoc = numberDoc;
    }

    public String getDocType() {
        return docType;
    }

    public void setDocType(String docType) {
        this.docType = docType;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getMiddleName() {
        return middleName;
    }

    public void setMiddleName(String middleName) {
        this.middleName = middleName;
    }

    public String getFirstLastName() {
        return firstLastName;
    }

    public void setFirstLastName(String firstLastName) {
        this.firstLastName = firstLastName;
    }

    public String getSecondLastName() {
        return secondLastName;
    }

    public void setSecondLastName(String secondLastName) {
        this.secondLastName = secondLastName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCityResidence() {
        return cityResidence;
    }

    public void setCityResidence(String cityResidence) {
        this.cityResidence = cityResidence;
    }


    public User(String firstName, String middleName, String firstLastName, String secondLastName, String phone, String address, String cityResidence, int numberDoc, String docType) {
        this.firstName = firstName;
        this.middleName = middleName;
        this.firstLastName = firstLastName;
        this.secondLastName = secondLastName;
        this.phone = phone;
        this.address = address;
        this.cityResidence = cityResidence;
        this.numberDoc = numberDoc;
        this.docType = docType;
    }

}
