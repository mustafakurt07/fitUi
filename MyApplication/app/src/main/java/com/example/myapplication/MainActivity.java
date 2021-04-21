package com.example.myapplication;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.squareup.picasso.Picasso;


public class MainActivity extends AppCompatActivity {
    private FirebaseDatabase firebaseDatabase = FirebaseDatabase.getInstance();
    private DatabaseReference databaseReference = firebaseDatabase.getReference();
    private DatabaseReference first = databaseReference.child("image");
    private DatabaseReference second = databaseReference.child("man");
    ImageView anasayfa, adam;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        loadUi();
        getData();


    }

    public void loadUi() {
        anasayfa = findViewById(R.id.main_image);//anasayfa image
        adam = findViewById(R.id.adam2);
    }

    public void getData() {
        first.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String link = snapshot.getValue(String.class);
                Picasso.get().load(link).into(anasayfa);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        second.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                String link = snapshot.getValue(String.class);
                Picasso.get().load(link).into(adam);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
        //toplam 6 foto için örnek oldugundan hepsine uygulamadım..
        //Yapılan işlem storageden token alıp database child ekleyip image erişip picasso üzerinden gösteriyorum.

    }


}
