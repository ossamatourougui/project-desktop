module com.example.reservation {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.auth.oauth2;
    requires google.cloud.firestore;
    requires firebase.admin;

    requires google.cloud.core;
    requires com.google.api.apicommon;
    requires com.google.auth;
    requires google.cloud.storage;
    requires jsr305;
    requires java.desktop;


    opens com.example.reservation to javafx.fxml;
    exports com.example.reservation;
}