package com.example.reservation;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
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
    @FXML
    public ImageView img_client;

    public void setData(client c, String s) {
        txt_cin.setText(""+c.getCIN());
        txt_nom.setText(""+c.getNOM());
        txt_prenom.setText(""+c.getPrenom());
        txt_email.setText(""+c.getEmail());
        txt_tele.setText(""+c.getTel());
        txt_adress.setText(""+c.getAdress());
        Image image;
        String url = c.getImage();
        if(c.getImage()==null){
            img_client.setImage(null);
        }else {
            try {
                image = new Image(url);
                img_client.setImage(image);

            }catch (Exception ex){
                img_client.setImage(null);
                System.out.println("probleme importation image");
            }

        }
        img_client.setFitWidth(44);
        img_client.setFitHeight(33);
        btn_supp.setStyle(s);
        //javafx.scene.shape.Rectangle clip = new javafx.scene.shape.Rectangle();
        //clip.setArcHeight(2);
        //clip.setArcWidth(2);
        //img_client.setClip(clip);
    }
    public void mouse_in() {
        btn_supp.setStyle("-fx-background-color : #F08080;-fx-background-radius:15");
    }
    public void mouse_out() {
        btn_supp.setStyle("-fx-background-color : #EBE8F9;-fx-background-radius:15");
    }

    public void mouse_click() {
    }
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
}
