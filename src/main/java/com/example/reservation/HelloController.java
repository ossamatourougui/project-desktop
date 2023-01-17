package com.example.reservation;

import javafx.fxml.FXML;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.scene.Node;
import javafx.scene.layout.VBox;


public class HelloController implements Initializable {
    @FXML
    private VBox pnItem = null;


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Node [] nodes = new Node[1];
        try {
            pnItem.getChildren().add(FXMLLoader.load(getClass().getResource("Item.fxml")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        };

        }
    }