package com.example.reservation;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;

public class controller_centreitem {

    @FXML
    ImageView image_centre;
    @FXML
    Label abv_name_centre;
    @FXML
    Label name_centre;
    public void set_centre(centre c){
        image_centre.setImage(null);
        abv_name_centre.setText(c.getAbwname());
        name_centre.setText(c.getName());
    }
}
