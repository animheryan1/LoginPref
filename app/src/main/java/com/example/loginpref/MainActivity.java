package com.example.loginpref;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText passwordEditText;
    private SharedPreferences sharedPreferences;

    public static String appPreference = "mypref";

    public static final String Name = "nameKey";
    public static final String Password = "passKey";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        nameEditText = findViewById(R.id.usernameEditText);
        passwordEditText = findViewById(R.id.passwordEditText);

        sharedPreferences = getSharedPreferences(appPreference, 0);
        checkAccount();

    }

    private void checkAccount() {
        if(sharedPreferences.contains(Name) && sharedPreferences.contains(Password)){
            visitAccount();
        }
    }

    public void login(View view) {
        if(!nameEditText.getText().toString().matches("") && !passwordEditText.getText().toString().matches("") ){
            visitAccount();
            saveToPref();
        }
    }

    private void visitAccount(){
        Intent intent = new Intent(this, Main2Activity.class);
        startActivity(intent);
        finish();
    }
    private void saveToPref() {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Name, nameEditText.getText().toString());
        editor.putString(Password, passwordEditText.getText().toString());
        editor.apply();
    }
}
