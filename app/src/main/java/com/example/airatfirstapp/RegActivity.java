package com.example.airatfirstapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class RegActivity extends AppCompatActivity {

    EditText etEmail, etPass;
    SharedPreferences sharedPref;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_reg);

        etEmail = findViewById(R.id.etEmailReg);
        etPass = findViewById(R.id.etPassReg);

        sharedPref = getSharedPreferences("myData", MODE_PRIVATE);
    }

    public void btnReg(View view) {
        String email = etEmail.getText().toString();
        String pass = etPass.getText().toString();

        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putString("email", email);
        editor.putString("pass", pass);
        editor.apply();
        Toast.makeText(this, "Вы зарегистрированы!", Toast.LENGTH_SHORT).show();
        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
    }
}