package com.example.reservation;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class contoller_reservation implements Initializable {

    reservation reservation;
    ArrayList<reservation> list = new ArrayList<>();

    @FXML
    VBox panel_centre;
    @FXML
    VBox panel_reservation;
    centre centre;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reservation=new reservation("ja178" , "efeafa", "2000-27-18", "18","18");
        centre=new centre("dada" , "ccffeeq", "CEF");
        list.add(reservation);
        for (int i = 0 ; i<3 ;i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("Item_list_reservation_client.fxml"));
                HBox item = fxmlLoader.load();
                controller_Item_list_reservation_client res =fxmlLoader.getController();
                res.setreservation(reservation);
                panel_reservation.getChildren().add(item);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        for (int i = 0 ; i<15 ;i++){
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("itemcentre.fxml"));
                Pane item = fxmlLoader.load();
                controller_centreitem res =fxmlLoader.getController();
                res.set_centre(centre);
                panel_centre.getChildren().add(item);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
    }

}
