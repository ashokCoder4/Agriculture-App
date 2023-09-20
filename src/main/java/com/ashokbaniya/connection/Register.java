package com.ashokbaniya.connection;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import android.util.Log;

public class Register extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        Button Register = findViewById(R.id.buttonRegister);
        TextView loginPage = findViewById(R.id.clickableText);
        TextView textView1 = findViewById(R.id.editTextText2);
        TextView textView2 = findViewById(R.id.editTextText3);
        TextView textView3 = findViewById(R.id.editTextText4);
        TextView textView4 = findViewById(R.id.editTextText5);
        TextView textView5 = findViewById(R.id.editTextText6);
        TextView textView6 = findViewById(R.id.editTextText7);

        loginPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Register.this, Login.class);
                startActivity(intent);
            }
        });

        Register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Generate a unique user ID using push() method
                DatabaseReference usersRef = mDatabase.child("users").push();
                // Get the text value from the TextView
                String textValue1 = textView1.getText().toString();
                String textValue2 = textView2.getText().toString();
                String textValue3 = textView3.getText().toString();
                String textValue4 = textView4.getText().toString();
                String textValue5 = textView5.getText().toString();
                String textValue6 = textView6.getText().toString();

                // Create a User object and set values
                User user = new User(textValue1,textValue2,"farmer",textValue3,textValue4,textValue5, textValue6);
                DatabaseReference usersReference = mDatabase.child("users");
                ValueEventListener valueEventListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        boolean userExists = false;
                        for (DataSnapshot usersSnapshot : dataSnapshot.getChildren()) {
                            String contact_no = usersSnapshot.child("contact_no").getValue(String.class);
                            String email = usersSnapshot.child("email").getValue(String.class);
                            if (contact_no != null && email != null  && contact_no.equals(textValue4) && email.equals(textValue3) ) {
                                userExists = true;
                                break;
                            }
                        }
                        if (userExists) {
                            Toast.makeText(Register.this, "User already exist ", Toast.LENGTH_SHORT).show();
                        } else {
                            usersRef.setValue(user);
                            Toast.makeText(Register.this, "User added successfully", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onCancelled(@NonNull DatabaseError databaseError) {
                        // Handle error
                    }
                };
                usersReference.addListenerForSingleValueEvent(valueEventListener);
            }
        });
    }
}