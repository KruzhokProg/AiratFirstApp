package com.example.airatfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText etEmail, etPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPass);
    }

    public void btnSignIn(View view) {
        String email = etEmail.getText().toString();
        String pass = etPassword.getText().toString();

        SharedPreferences sharedPref = getSharedPreferences("myData", MODE_PRIVATE);
        String userEmail = sharedPref.getString("email", "");
        String userPass = sharedPref.getString("pass", "");

        if(email.equals(userEmail) && pass.equals(userPass)){
            //Toast.makeText(this, "Hello Admin!", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this, WelcomeActivity.class);
            startActivity(i);
        }
        else{
            Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
        }
    }

    public void btnSignUp(View view) {
        Intent i = new Intent(this, RegActivity.class);
        startActivity(i);
    }
}