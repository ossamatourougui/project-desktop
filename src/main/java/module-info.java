module com.example.reservation {
    requires javafx.controls;
    requires javafx.fxml;
    requires com.google.auth.oauth2;
    requires google.cloud.firestore;
    requires firebase.admin;


    opens com.example.reservation to javafx.fxml;
    exports com.example.reservation;
}