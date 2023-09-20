package com.ashokbaniya.connection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class UserProfile extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_profile);
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        User user = new User("ashok","ashok","farmer","ashok","ashok","ashok","ashok");
        SharedPreferences sharedPreferences = getSharedPreferences("MySession", Context.MODE_PRIVATE);
        String userID = sharedPreferences.getString("userID", "");
        Log.d("USERPROFILE",userID);

        Button viewDetails = findViewById(R.id.button13);
        Button SellCrops = findViewById(R.id.button8);
        Button cropsOnSale=findViewById(R.id.button9);
        Button pesticides = findViewById(R.id.button4);
        // Set a click event listener for the button
        viewDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile.this, UpdateUser.class);
                // Start the target activity
                startActivity(intent);
            }});

        SellCrops.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile.this, SellCultivatedCrops.class);
                // Start the target activity
                startActivity(intent);
            }});

        cropsOnSale.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(UserProfile.this, SellingCropsView.class);
                // Start the target activity
                startActivity(intent);
            }});
    }
}