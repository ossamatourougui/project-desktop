package com.example.reservation;

public class centre {
    String image ;
    String name ;
    String abwname ;

    public centre(String image, String name, String abwname) {
        this.image = image;
        this.name = name;
        this.abwname = abwname;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbwname() {
        return abwname;
    }

    public void setAbwname(String abwname) {
        this.abwname = abwname;
    }
}
