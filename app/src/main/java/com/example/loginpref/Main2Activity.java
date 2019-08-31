package com.example.loginpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import static com.example.loginpref.MainActivity.Name;
import static com.example.loginpref.MainActivity.Password;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
    }

    public void logout(View view) {
        SharedPreferences preferences = getSharedPreferences("mypref", 0);
        preferences.edit().remove(Name).apply();
        preferences.edit().remove(Password).apply();

        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
