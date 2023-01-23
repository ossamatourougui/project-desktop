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

import javax.annotation.Nullable;
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
    public Pane panel;

    public VBox pnItem = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        lblStatus.setText("Dachboard");
        try {
            panel.getChildren().add(FXMLLoader.load(getClass().getResource("homm.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        //pnItem.getChildren().add(FXMLLoader.load(getClass().getResource("Item.fxml")));
    }
    public   void handelClick(ActionEvent event) throws IOException {
        if (event.getSource() == btnDachboard)
        {
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
            lblStatus.setText("Clients");
            panel.getChildren().clear();
            try {
                panel.getChildren().add(FXMLLoader.load(getClass().getResource("clients.fxml")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
        else  if (event.getSource() == btnComptes)
        {
            lblStatus.setText("Comptes");
            panel.getChildren().clear();
            try {
                panel.getChildren().add(FXMLLoader.load(getClass().getResource("comptes.fxml")));
            } catch (IOException e) {
                throw new RuntimeException(e);
            }

        }
    }
}

