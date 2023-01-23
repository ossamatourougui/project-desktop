package com.example.reservation;


public class client {
    String CIN;

    public String getCIN() {
        return CIN;
    }

    public void setCIN(String CIN) {
        this.CIN = CIN;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getAdress() {
        return Adress;
    }

    public void setAdress(String adress) {
        Adress = adress;
    }

    public String getTel() {
        return Tel;
    }

    public void setTel(String tel) {
        Tel = tel;
    }

    public String getPrenom() {
        return Prenom;
    }

    public void setPrenom(String prenom) {
        Prenom = prenom;
    }

    public String getNOM() {
        return NOM;
    }

    public void setNOM(String NOM) {
        this.NOM = NOM;
    }

    String Email;
    String Adress;
    String Tel;
    String Prenom;

    public client(String CIN, String email, String adress, String tel, String prenom, String NOM) {
        this.CIN = CIN;
        Email = email;
        Adress = adress;
        Tel = tel;
        Prenom = prenom;
        this.NOM = NOM;
    }
    public client() {

    }

    String NOM;
}
