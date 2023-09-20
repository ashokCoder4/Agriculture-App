package com.ashokbaniya.connection;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.content.Intent;
import android.view.View;

public class HomePage extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
        Button goToLogin = findViewById(R.id.button2);
        Button goToSignup = findViewById(R.id.button);
        goToLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to specify the target activity
                Intent intent = new Intent(HomePage.this, Login.class);
                // Start the target activity
                startActivity(intent);
            }
        });
        goToSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Create an Intent to specify the target activity
                Intent intent = new Intent(HomePage.this, Register.class);
                // Start the target activity
                startActivity(intent);
            }
        });
    }
}