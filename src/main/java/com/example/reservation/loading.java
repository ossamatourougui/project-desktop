package com.example.reservation;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.ResourceBundle;

public class loading implements Initializable {
    @FXML
    Text txt_loading;
    int incrementation;
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        String[] txt = {"Loading" , "Loading ." ,"Loading .." ,"Loading ..."  };
        incrementation =0;
        new Thread(()->{
            while (true) {
                Platform.runLater(()->{
                    txt_loading.setText(txt[incrementation]);
                });
                incrementation++;
                if(incrementation==4)incrementation=0;
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }

            }
        }).start();
    }

}
