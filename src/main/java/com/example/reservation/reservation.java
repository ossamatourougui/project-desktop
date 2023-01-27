package com.example.reservation;

public class reservation {

    String cin;
    String name;
    String date;
    String heureD;

    public reservation(String cin, String name, String date, String heureD, String heureF) {
        this.cin = cin;
        this.name = name;
        this.date = date;
        this.heureD = heureD;
        this.heureF = heureF;
    }
    public reservation() {

    }

    public String getCin() {
        return cin;
    }

    public void setCin(String cin) {
        this.cin = cin;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getHeureD() {
        return heureD;
    }

    public void setHeureD(String heureD) {
        this.heureD = heureD;
    }

    public String getHeureF() {
        return heureF;
    }

    public void setHeureF(String heureF) {
        this.heureF = heureF;
    }

    String heureF;
}
