package com.example.reservation;

import com.google.cloud.firestore.*;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.shape.Rectangle;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.ResourceBundle;

public class contoller_reservation implements Initializable {

    reservation reservation;
    ArrayList<reservation> list_r = new ArrayList<>();
    ArrayList<centre> list_c = new ArrayList<>();

    Firestore firestore;
    @FXML
    VBox panel_centre;
    @FXML
    VBox panel_reservation;
    centre centre;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        reservation=new reservation("ja178" , "efeafa", "2000-27-18", "18:00","18:00");
        list_r.add(reservation);
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
            try {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("loading_data.fxml"));
                AnchorPane item = fxmlLoader.load();
                loading res =fxmlLoader.getController();
                panel_centre.getChildren().add(item);
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }

        new Thread(()->{
            while (true){
                Platform.runLater(()->{
                    load_data();
                });
                if (list_c.size()!=0)break;
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }

        }).start();
    }

    public void setdata(Firestore firestore){
        this.firestore = firestore;
        if(firestore != null)System.out.println("3amar");
    }
    public synchronized void load_data(){
        com.example.reservation.reservation re = new reservation();
        firestore.collection("centres").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirestoreException e) {
                list_c.clear();
                for (DocumentSnapshot item :queryDocumentSnapshots){
                    centre = new centre();
                    centre.setName(item.getString("nom"));
                    centre.setAbwname(item.getString("abnom"));
                    centre.setImage(item.getString("img"));
                    list_c.add(centre);
                }

            }
        });
        if (list_c.size()!=0) {
            panel_centre.getChildren().clear();
            for (int i = 0 ; i<list_c.size();i++){
                try {
                    FXMLLoader fxmlLoader = new FXMLLoader();
                    fxmlLoader.setLocation(getClass().getResource("itemcentre.fxml"));
                    Pane item = fxmlLoader.load();
                    controller_centreitem res =fxmlLoader.getController();
                    res.setdata(list_c.get(i));
                    panel_centre.getChildren().add(item);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }

    }
}
