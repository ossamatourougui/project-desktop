package com.example.reservation;

import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class controller implements Initializable {

    public VBox pnItem = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        try {
            pnItem.getChildren().add(FXMLLoader.load(getClass().getResource("Item.fxml")));
            pnItem.getChildren().add(FXMLLoader.load(getClass().getResource("Item.fxml")));
            pnItem.getChildren().add(FXMLLoader.load(getClass().getResource("Item.fxml")));
            pnItem.getChildren().add(FXMLLoader.load(getClass().getResource("Item.fxml")));
            pnItem.getChildren().add(FXMLLoader.load(getClass().getResource("Item.fxml")));
            pnItem.getChildren().add(FXMLLoader.load(getClass().getResource("Item.fxml")));
            pnItem.getChildren().add(FXMLLoader.load(getClass().getResource("Item.fxml")));
            pnItem.getChildren().add(FXMLLoader.load(getClass().getResource("Item.fxml")));
            pnItem.getChildren().add(FXMLLoader.load(getClass().getResource("Item.fxml")));
            pnItem.getChildren().add(FXMLLoader.load(getClass().getResource("Item.fxml")));
            pnItem.getChildren().add(FXMLLoader.load(getClass().getResource("Item.fxml")));
            pnItem.getChildren().add(FXMLLoader.load(getClass().getResource("Item.fxml")));
            pnItem.getChildren().add(FXMLLoader.load(getClass().getResource("Item.fxml")));
            pnItem.getChildren().add(FXMLLoader.load(getClass().getResource("Item.fxml")));
            pnItem.getChildren().add(FXMLLoader.load(getClass().getResource("Item.fxml")));
            pnItem.getChildren().add(FXMLLoader.load(getClass().getResource("Item.fxml")));

        } catch (IOException e) {
            throw new RuntimeException(e);
        };
    }
}

