package com.example.reservation;


import com.google.cloud.firestore.*;
import com.google.cloud.firestore.EventListener;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.annotations.Nullable;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.*;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.*;

public class controller_homme implements Initializable {
    @FXML
    public VBox pnItem = null;
    @FXML
    public Button load = null;
    @FXML
    public Label title_client = null;
    Label cin =new Label();
    Label nom =new Label();
    Label prenom =new Label();
    Label tele =new Label();
    Label adress =new Label();
    Label email =new Label();
    Button supp =new Button();
    Region r1 = new Region();
    HBox row;
    Firestore firestore = null;
    ArrayList<client> list = new ArrayList<>();
    client c;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            FXMLLoader fxmload = new FXMLLoader();
            fxmload.setLocation(getClass().getResource("loading_data.fxml"));
            Pane item = fxmload.load();
            loading controllerItem = fxmload.getController();
            pnItem.getChildren().add(item);

        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true){
                    Platform.runLater(()->{
                        put_data_intable();
                    });
                    try {
                        Thread.sleep(3000);
                    }catch (Exception e){System.out.println("error sleep Thear");}
                }

            }
        }).start();
    }
    public void click_refrech(){
        put_data_intable();
    }
    public void load_data(){
        firestore.collection("clients").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirestoreException e) {
                System.out.println("inside");
                list.clear();
                for(DocumentSnapshot item :queryDocumentSnapshots){
                    c = new client();
                    c.setCIN(item.getString("CIN"));
                    c.setNOM(item.getString("NOM"));
                    c.setPrenom(item.getString("Prenom"));
                    c.setEmail(item.getString("Email"));
                    c.setTel(item.getString("tel"));
                    c.setAdress(item.getString("Adress"));
                    c.setImage(item.getString("ref"));
                    list.add(c);
                }
                System.out.println("list :"+list.size());

            }
        });
    }

    public void setfirestore(Firestore fs) {
        this.firestore = fs;
    }
    public synchronized void put_data_intable(){

        if(list.size() == 0){
            load_data();
            System.out.println("empty");
        }
        else{
            pnItem.getChildren().clear();
            System.out.println("not empty");
            try {
                for (int i =0 ; i<list.size() ;i++ ){
                    FXMLLoader fxmload = new FXMLLoader();
                    fxmload.setLocation(getClass().getResource("Item.fxml"));
                    HBox item = fxmload.load();
                    controller_item controllerItem = fxmload.getController();
                    controllerItem.setData(list.get(i) , "-fx-background-color : #EBE8F9;-fx-background-radius: 25;");
                    pnItem.getChildren().add(item);
                }
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }


    }
}
