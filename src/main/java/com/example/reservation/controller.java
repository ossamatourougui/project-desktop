package com.example.reservation;

import com.google.api.core.ApiFuture;
import com.google.cloud.firestore.*;
import com.google.cloud.storage.*;
import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.cloud.FirestoreClient;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javax.sound.sampled.AudioInputStream;

import javax.annotation.Nullable;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;
public class controller implements Initializable {
    @FXML
    public Button btnCentre;

    @FXML
    public Button btnClients;

    @FXML
    public Button btnComptes;

    @FXML
    public Button btnDachboard;

    @FXML
    public Button btnReservation;

    @FXML
    public Label lblStatus;

    @FXML
    public Pane pnlStatus;

    @FXML
    public VBox panel = null;

    String filepath;
    Firestore firestore;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        lblStatus.setText("Dachboard");
        try {
            panel.getChildren().add(FXMLLoader.load(getClass().getResource("homm.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream("./serviceaccountkey.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        FirebaseOptions options = null;
        try {
            options = new FirebaseOptions.Builder().
                    setCredentials(com.google.auth.oauth2.GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://<reservationcentre>.firebaseio.com/")
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FirebaseApp.initializeApp(options);
        firestore = FirestoreClient.getFirestore();
        Map<String ,Object> data = new HashMap<>();
        data.put("try1", "faild");
        data.put("try2", "suscessfully");
        data.put("try3", "suscessfully");
        data.put("try4", "suscessfully");
        //ApiFuture<WriteResult> future =firestore.collection("aacezc").document("czcez").set(data);
        System.out.println("Successfully");
        filepath ="src\\main\\resources\\sounds\\cheb.wav";
    }
    private void playmusic(String location) {
        try{
            File musicpath = new File(location);
            if(musicpath.exists()){
                AudioInputStream audio = AudioSystem.getAudioInputStream(musicpath);
                Clip clip = AudioSystem.getClip();
                clip.open(audio);
                clip.start();
            }
            else{
                System.err.println("not found");
            }
        }catch(Exception ex){
            System.err.println(""+ex.getMessage());
        }

    }
    public   void handelClick(ActionEvent event) throws IOException {
        if (event.getSource() == btnDachboard)
        {
            playmusic(filepath);
            mouse_click_changedbackground(0);
            lblStatus.setText("Dachboard");
            panel.getChildren().clear();
            try {
                panel.getChildren().add(FXMLLoader.load(getClass().getResource("homm.fxml")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        else  if (event.getSource() == btnCentre)
        {
            playmusic(filepath);
            mouse_click_changedbackground(1);
            lblStatus.setText("Centre");
            panel.getChildren().clear();
            try {
                panel.getChildren().add(FXMLLoader.load(getClass().getResource("centre.fxml")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }


        }
        else  if (event.getSource() == btnReservation)
        {
            playmusic(filepath);
            mouse_click_changedbackground(2);
            lblStatus.setText("Reservation");
            panel.getChildren().clear();
            try {
                panel.getChildren().add(FXMLLoader.load(getClass().getResource("Reservaition.fxml")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        else  if (event.getSource() == btnClients)
        {
            playmusic(filepath);
            mouse_click_changedbackground(3);
            lblStatus.setText("Clients");
            panel.getChildren().clear();
            try {
                FXMLLoader fxmload = new FXMLLoader();
                fxmload.setLocation(getClass().getResource("clients.fxml"));
                Pane item = fxmload.load();
                controller_homme controllerItem = fxmload.getController();
                controllerItem.setfirestore(firestore);
                panel.getChildren().add(item);

            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        else  if (event.getSource() == btnComptes)
        {
            playmusic(filepath);
            mouse_click_changedbackground(4);
            lblStatus.setText("Comptes");
            panel.getChildren().clear();
            try {
                FXMLLoader fxmload = new FXMLLoader();
                fxmload.setLocation(getClass().getResource("comptes.fxml"));
                Pane item = fxmload.load();
                controller_comptes controllerItem = fxmload.getController();
                controllerItem.setfirestore(firestore);
                panel.getChildren().add(item);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
    public void mouse_click_changedbackground(int index){
        btnCentre.setStyle("-fx-background-color :  #EBE8F9");
        btnClients.setStyle("-fx-background-color :  #EBE8F9");
        btnComptes.setStyle("-fx-background-color :  #EBE8F9");
        btnDachboard.setStyle("-fx-background-color :  #EBE8F9");
        btnReservation.setStyle("-fx-background-color : #EBE8F9");
        if(index == 0)btnDachboard.setStyle("-fx-background-color : #c4c4c4;");
        if(index == 1)btnCentre.setStyle("-fx-background-color : #c4c4c4;");
        if(index == 2)btnReservation.setStyle("-fx-background-color : #c4c4c4;");
        if(index == 3)btnClients.setStyle("-fx-background-color : #c4c4c4;");
        if(index == 4)btnComptes.setStyle("-fx-background-color : #c4c4c4;");

    }
}

