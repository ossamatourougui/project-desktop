package com.example.reservation;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.net.URL;
import java.util.ResourceBundle;

public class controller_item implements Initializable {
    @FXML
    public Label txt_cin;
    @FXML
    public Label txt_nom;
    @FXML
    public Label txt_prenom;
    @FXML
    public Label txt_adress;
    @FXML
    public Label txt_email;
    @FXML
    public Label txt_tele;
    @FXML
    public Button btn_supp;

    @FXML
    public HBox row;

    public void setData(client c, String s) {
        txt_cin.setText(""+c.getCIN());
        txt_nom.setText(""+c.getNOM());
        txt_prenom.setText(""+c.getPrenom());
        txt_email.setText(""+c.getEmail());
        txt_tele.setText(""+c.getTel());
        txt_adress.setText(""+c.getAdress());
        //row.setStyle("-fx-background-color : #BDBBC3");
    }
    public void mouse_in() {
        btn_supp.setStyle("-fx-background-color : #F08080");
    }
    public void mouse_out() {
        btn_supp.setStyle("-fx-background-color : #EBE8F9");
    }

    public void mouse_click() {
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
