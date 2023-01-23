package com.example.reservation;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
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

