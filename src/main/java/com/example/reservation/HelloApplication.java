package com.example.reservation;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class HelloApplication extends Application {
    private double x,y;
    @Override
    public void start(Stage primarystage) throws Exception {
        Parent root =  FXMLLoader.load(getClass().getResource("hello-view.fxml"));
        primarystage.setScene(new Scene(root));
        primarystage.initStyle(StageStyle.UNDECORATED);
        primarystage.show();

        root.setOnMousePressed(mouseEvent -> {
            x = mouseEvent.getSceneX();
            y = mouseEvent.getSceneY();

        });
        root.setOnMouseDragged(mouseEvent -> {
            primarystage.setX(mouseEvent.getSceneX()-x);
            primarystage.setY(mouseEvent.getSceneY()-y);
        });

    }
    public static void main(String[] args) {
        launch();
    }
}