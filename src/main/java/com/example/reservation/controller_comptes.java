package com.example.reservation;

import com.google.cloud.firestore.*;
import com.google.firebase.database.annotations.Nullable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class controller_comptes implements Initializable {

    @FXML
    Rectangle rectangle_test;
    @FXML
    VBox root;
    @FXML
    ImageView imageView;

    Firestore firestore;
    String img = null;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        Rectangle roundRect = new Rectangle(0, 0, 200, 200);
        roundRect.setArcHeight(50);
        roundRect.setArcWidth(50);
        roundRect.setFill(Color.RED);
        roundRect.setEffect(new DropShadow());
        root.getChildren().add(roundRect);
    }

    public void setfirestore(Firestore firestore) {
        this.firestore = firestore;
    }
}
