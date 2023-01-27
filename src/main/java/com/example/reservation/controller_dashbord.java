package com.example.reservation;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import ui.RingProgressIndicator;
import ui.RingProgressIndicatorSkin;

import java.net.URL;
import java.util.ResourceBundle;

public class controller_dashbord  implements Initializable {

    @FXML
    StackPane stackpanel;
    int progress =0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RingProgressIndicator ringProgressIndicator = new RingProgressIndicator();
        ringProgressIndicator.setRingWidth(0);
        ringProgressIndicator.makeIndeterminate();
        stackpanel.getChildren().add(ringProgressIndicator);
        new Thread(()->{
            while (true){

                try {
                    Thread.sleep(80);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                Platform.runLater(()->{
                    progress++;
                    ringProgressIndicator.setProgress(progress);
                });
                if(progress == 100){
                    break;
                }

            }
        }).start();
    }
}
