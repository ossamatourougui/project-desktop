package com.example.reservation;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import ui.RingProgressIndicator;
import ui.RingProgressIndicatorSkin;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class controller_dashbord  implements Initializable {

    @FXML
    private LineChart<?, ?> chart;
    @FXML
    private HBox hboxcontent;
    @FXML
    StackPane stackpanel;
    int progress =0;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        RingProgressIndicator ringProgressIndicator = new RingProgressIndicator();
        ringProgressIndicator.setRingWidth(0);
        ringProgressIndicator.setBackground(null);
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
        try {
            hboxcontent.getChildren().add(FXMLLoader.load(getClass().getResource("item_hoom_mois.fxml")));
            hboxcontent.getChildren().add(FXMLLoader.load(getClass().getResource("item_hoom_mois.fxml")));
            hboxcontent.getChildren().add(FXMLLoader.load(getClass().getResource("item_hoom_mois.fxml")));
            hboxcontent.getChildren().add(FXMLLoader.load(getClass().getResource("item_hoom_mois.fxml")));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

            XYChart.Series series = new XYChart. Series();
            series.getData().add(new XYChart.Data(  "lun",  5));
            series.getData() .add(new XYChart.Data( "mar",  1));
            series.getData() .add(new XYChart.Data( "mer", 6));
            series.getData() .add(new XYChart.Data( "jeu", 0));
            series.getData() .add(new XYChart.Data( "ven", 1));
            series.getData() .add(new XYChart.Data( "sam", 6));
            series.getData() .add(new XYChart.Data( "dim", 3));
                    chart.getData().add(series);
                    chart.setStyle("-fx-background-color: transparent;");
                   // series.getNode().setStyle("-fx-stroke: green");

    }
}
