package com.example.reservation;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;

import java.net.URL;
import java.util.ResourceBundle;

public class controller_centreitem implements Initializable {

    @FXML
    ImageView image_centre;
    @FXML
    Label abv_name_centre;
    @FXML
    Label name_centre;
    @FXML
    Rectangle rec;
    @FXML
    Pane panee;
    public void setdata(centre c){
        name_centre.setText(""+c.getName());
        abv_name_centre.setText(""+c.getAbwname());
        Image image;
        String url =""+c.getImage();
        try {
            image = new Image(url);
            image_centre.setImage(image);

        }catch (Exception ex){
            image_centre.setImage(null);
            System.out.println("probleme importation image");
        }
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        rec.setArcHeight(50);
        rec.setArcWidth(50);
        rec.setEffect(new DropShadow());
        rec.setFill(Color.rgb(240,240,240));
    }
    public void mouse_in(){
        rec.setFill(Color.rgb(178,178,178));
    }
    public void mouse_out(){
        rec.setFill(Color.rgb(240,240,240));
    }
}
