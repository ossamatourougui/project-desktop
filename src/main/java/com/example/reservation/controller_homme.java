package com.example.reservation;


import com.google.cloud.firestore.*;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.cloud.FirestoreClient;
import com.google.firebase.database.annotations.Nullable;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.ResourceBundle;

public class controller_homme implements Initializable {
    @FXML
    public VBox pnItem = null;
    @FXML
    public Button load = null;
    @FXML
    public Label title_client = null;
    Label cin =new Label();
    Label nom =new Label();
    Label prenom =new Label();
    Label tele =new Label();
    Label adress =new Label();
    Label email =new Label();
    Button supp =new Button();
    Region r1 = new Region();
    HBox row;
    Firestore firestore;
    ArrayList<client> list = new ArrayList<>();
    client c;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        c = new client();
        for (int i =0 ; i<20;i++){
            r1 = new Region();
            row = new HBox(24);
            row.setPadding(new Insets(10, 10 ,10 ,10));
            row.setAlignment(Pos.CENTER);
            cin =new Label();
            nom =new Label();
            prenom =new Label();
            tele =new Label();
            adress =new Label();
            email =new Label();
            supp =new Button();
            cin.setText("null");
            email.setText("null");
            adress.setText("null");
            tele.setText("null");
            prenom.setText("null");
            nom.setText("null");
            supp.setText("Supprimer");
            row.setPadding(new Insets(20 ,20 , 20,20));
            //row.setAlignment(Pos.CENTER);
            row.getChildren().addAll(cin , nom , prenom , email, tele, adress,supp,r1);
            pnItem.getChildren().add(row);
            System.out.println("jaw");
        }
        FileInputStream serviceAccount = null;
        try {
            serviceAccount = new FileInputStream("./serviceaccountkey.json");
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        FirebaseOptions options = null;
        try {
            options = new FirebaseOptions.Builder().
                    setCredentials(com.google.auth.oauth2.GoogleCredentials.fromStream(serviceAccount))
                    .setDatabaseUrl("https://<reservationcentre>.firebaseio.com/")
                    .build();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        FirebaseApp.initializeApp(options);
        firestore = FirestoreClient.getFirestore();
        Map<String ,Object> data = new HashMap<>();
        data.put("try1", "faild");
        data.put("try2", "suscessfully");
        data.put("try3", "suscessfully");
        data.put("try4", "suscessfully");
        //ApiFuture<WriteResult> future =firestore.collection("aacezc").document("czcez").set(data);
        System.out.println("Successfully");
        load_data();
        /*
        if (load_data()) {

            for(int i =0 ; i<list.size();i++){
                r1 = new Region();
                row = new HBox(24);
                row.setPadding(new Insets(10, 10 ,10 ,10));
                row.setAlignment(Pos.CENTER);
                cin =new Label();
                nom =new Label();
                prenom =new Label();
                tele =new Label();
                adress =new Label();
                email =new Label();
                supp =new Button();
                cin.setText(""+list.get(i).getCIN());
                email.setText(""+list.get(i).getEmail());
                adress.setText(""+list.get(i).getAdress());
                tele.setText(""+list.get(i).getTel());
                prenom.setText(""+list.get(i).getPrenom());
                nom.setText(""+list.get(i).getNOM());
                supp.setText("Supprimer");
                row.setPadding(new Insets(20 ,20 , 20,20));
                //row.setAlignment(Pos.CENTER);
                row.getChildren().addAll(cin , nom , prenom , email, tele, adress,supp,r1);
                pnItem.getChildren().add(row);
                System.out.println("jaw");
            }
        }
        else{
                r1 = new Region();
                row = new HBox(24);
                row.setPadding(new Insets(10, 10 ,10 ,10));
                row.setAlignment(Pos.CENTER);
                cin =new Label();
                nom =new Label();
                prenom =new Label();
                tele =new Label();
                adress =new Label();
                email =new Label();
                supp =new Button();
                cin.setText("null");
                email.setText("null");
                adress.setText("null");
                tele.setText("null");
                prenom.setText("null");
                nom.setText("null");
                supp.setText("Supprimer");
                row.setPadding(new Insets(20 ,20 , 20,20));
                //row.setAlignment(Pos.CENTER);
                row.getChildren().addAll(cin , nom , prenom , email, tele, adress,supp,r1);
                pnItem.getChildren().add(row);
                System.out.println("jaw");

        }
*/
    }
    public void click_refrech(){
        pnItem.getChildren().clear();
        for(int i =0 ; i<list.size();i++){
            r1 = new Region();
            row = new HBox(24);
            row.setPadding(new Insets(10, 10 ,10 ,10));
            row.setAlignment(Pos.CENTER);
            cin =new Label();
            nom =new Label();
            prenom =new Label();
            tele =new Label();
            adress =new Label();
            email =new Label();
            supp =new Button();
            cin.setText(""+list.get(i).getCIN());
            email.setText(""+list.get(i).getEmail());
            adress.setText(""+list.get(i).getAdress());
            tele.setText(""+list.get(i).getTel());
            prenom.setText(""+list.get(i).getPrenom());
            nom.setText(""+list.get(i).getNOM());
            supp.setText("Supprimer");
            row.setPadding(new Insets(20 ,20 , 20,20));
            //row.setAlignment(Pos.CENTER);
            row.getChildren().addAll(cin , nom , prenom , email, tele, adress,supp,r1);
            pnItem.getChildren().add(row);
            System.out.println("jaw");
        }
    }
    public void load_data(){
        firestore.collection("clients").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirestoreException e) {
                System.out.println("inside");
                for(DocumentSnapshot item :queryDocumentSnapshots){
                    c = new client();
                    c.setCIN(item.getString("CIN"));
                    c.setNOM(item.getString("NOM"));
                    c.setPrenom(item.getString("Prenom"));
                    c.setEmail(item.getString("Email"));
                    c.setTel(item.getString("tel"));
                    c.setAdress(item.getString("Adress"));
                    list.add(c);
                    System.out.println("cin  "+c.getCIN().toString());
                    System.out.println("nom  "+c.getNOM().toString());
                    System.out.println("prenom  "+c.getPrenom().toString());
                    System.out.println("adress  "+c.getAdress().toString());
                    System.out.println("email  "+c.getEmail().toString());
                    System.out.println("tel  "+c.getTel().toString());
                }

            }
        });
    }
}
