package com.example.reservation;

import com.google.cloud.firestore.*;
import com.google.firebase.database.annotations.Nullable;

import java.util.ArrayList;

public class thead_test extends Thread{
    Firestore firestore;

    public ArrayList<client> getList() {
        return list;
    }

    public void setList(ArrayList<client> list) {
        this.list = list;
    }

    ArrayList<client> list = new ArrayList<>();
    client c = new client();
    public thead_test(Firestore fs) {
        this.firestore = fs;
    }

    @Override
    public void run() {
        while (true){

            if(list.size() == 0){load_data();System.out.println("empty");}
            else{
                System.out.println("not empty");
                break;
            }
            try {
                Thread.sleep(3000);
            }catch (Exception e){System.out.println("error sleep Thear");}
        }
    }
    public void load_data(){
        firestore.collection("clients").addSnapshotListener(new EventListener<QuerySnapshot>() {
            @Override
            public void onEvent(@Nullable QuerySnapshot queryDocumentSnapshots, @Nullable FirestoreException e) {
                System.out.println("inside");
                list.clear();
                for(DocumentSnapshot item :queryDocumentSnapshots){
                    c = new client();
                    c.setCIN(item.getString("CIN"));
                    c.setNOM(item.getString("NOM"));
                    c.setPrenom(item.getString("Prenom"));
                    c.setEmail(item.getString("Email"));
                    c.setTel(item.getString("tel"));
                    c.setAdress(item.getString("Adress"));
                    list.add(c);
                }
                System.out.println("list :"+list.size());

            }
        });
    }
}
