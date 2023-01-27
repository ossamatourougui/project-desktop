package com.example.reservation;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.net.URL;
import java.util.ResourceBundle;

public class controller_Item_list_reservation_client implements Initializable {

    @FXML
    Label cin;
    @FXML
    Label name;
    @FXML
    Label date;
    @FXML
    Label heureD;
    @FXML
    Label heureF;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cin.setText("dazdaz");
        name.setText("dazdaz");
        date.setText("dazdaz");
        heureD.setText("dazdaz");
        heureF.setText("dazdaz");
    }
    public void setreservation(reservation reservation){
        cin.setText(reservation.getCin());
        name.setText(reservation.getName());
        date.setText(reservation.getDate());
        heureD.setText(reservation.getHeureD());
        heureF.setText(reservation.getHeureF());
    }
}
