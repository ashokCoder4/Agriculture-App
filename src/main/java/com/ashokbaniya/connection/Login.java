package com.ashokbaniya.connection;

import static android.icu.lang.UCharacter.GraphemeClusterBreak.V;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class Login extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        SharedPreferences sharedPreferences = getSharedPreferences("MySession", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        TextView registerTextView = findViewById(R.id.clickableText);
        registerTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to specify the target activity
                Intent intent = new Intent(Login.this, Register.class);
                // Start the target activity
                startActivity(intent);
            }
        });

        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference();
        Button login = findViewById(R.id.button6);
        // Set a click event listener for the button
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText textView1 = findViewById(R.id.editTextText);
                String user_id = textView1.getText().toString();
                EditText textView2 = findViewById(R.id.editTextTextPassword);
                String password = textView2.getText().toString();
                DatabaseReference usersReference = mDatabase.child("users");
                ValueEventListener valueEventListener = new ValueEventListener() {
                    @Override
                    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                        boolean userExists = false;
                        for (DataSnapshot usersSnapshot : dataSnapshot.getChildren()) {
                            String contact_no = usersSnapshot.child("contact_no").getValue(String.class);
                            String email = usersSnapshot.child("email").getValue(String.class);
                            String pswd = usersSnapshot.child("password").getValue(String.class);
                            String id = usersSnapshot.getKey();
                            Log.d("userID",String.valueOf(id));
                            if ( (contact_no.equals(user_id) || email.equals(user_id)) && pswd.equals(password) ) {
                                userExists = true;
                                editor.putString("userID", id);
                                editor.apply();
                                break;
                            }
                        }
                        if (userExists) {
                            // Do something if the user exists
                            Intent intent = new Intent(Login.this, UserProfile.class);
                            // Start the target activity
                            startActivity(intent);
                            Toast.makeText(Login.this, "logged in sucessfully ", Toast.LENGTH_SHORT).show();
                        } else {
                            // Do something if the user doesn't exist
                            // Set the User object as value
                            Toast.makeText(Login.this, "User not found", Toast.LENGTH_SHORT).show();
                            Log.d("ashokmesg3","no boss");

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