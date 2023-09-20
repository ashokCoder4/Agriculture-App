package com.ashokbaniya.connection;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class UpdateUser extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_user);
        Button updateUserDetails = findViewById(R.id.button3);
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        User user = new User("name","email","farmer","email1232@gmail.com","4567890","ktm","ashok123");
        SharedPreferences sharedPreferences = getSharedPreferences("MySession", Context.MODE_PRIVATE);
        String userID = sharedPreferences.getString("userID", "");
        Log.d("USERPROFILE",userID);
        updateUserDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatabaseReference usersRef = mDatabase.child("users");
                usersRef.child("-Ndbf4I5-ind5uJaRrCP").setValue(user, new DatabaseReference.CompletionListener() {
                    @Override
                    public void onComplete(DatabaseError error, DatabaseReference ref) {
                        if (error != null) {
                            // Handle the error
                        } else {
                            // Data updated successfully
                        }
                    }
                });
            }});

    }
}