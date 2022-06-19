package com.example.timeline_two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText mainUsername,mainPassword;
    Button mainLogin;
    TextView mainRegister,mainAdmin;
    DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainRegister= findViewById(R.id.activity_main_register);
        mainAdmin = findViewById(R.id.activity_main_AdminLogin);
        mainLogin = findViewById(R.id.activity_main_loginbtn);
        mainUsername = findViewById(R.id.activity_main_username);
        mainPassword = findViewById(R.id.activity_main_password);

        SharedPreferences preferences = getSharedPreferences("preference", MODE_PRIVATE);

        if (preferences.getString("username", "") != "" && preferences.getString("password", "") != "") { // code to understand
            Intent intent = new Intent(MainActivity.this, MyProfile.class);
            startActivity(intent);
        }

        mainLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String username = mainUsername.getText().toString();
                String password = mainPassword.getText().toString();

                Cursor checkUser = dataBaseHelper.loginCheck(username, password);

                if (checkUser.moveToFirst()) {
                    do {
                        int userName = checkUser.getColumnIndex("username");
                        int fullName = checkUser.getColumnIndex("fullname");
                        int contactNum = checkUser.getColumnIndex("phoneNumber");
                        int mail = checkUser.getColumnIndex("email");
                        int place = checkUser.getColumnIndex("address");
                        int passcode = checkUser.getColumnIndex("password");
                        int dayRegister = checkUser.getColumnIndex("day");
                        int id = checkUser.getColumnIndex("individual_id");

                        SharedPreferences preferences = getSharedPreferences("preference", MODE_PRIVATE);
                        preferences.edit().putString("userName", checkUser.getString(userName)).apply();
                        preferences.edit().putString("fullName", checkUser.getString(fullName)).apply();
                        preferences.edit().putString("contactNum", checkUser.getString(contactNum)).apply();
                        preferences.edit().putString("mail", checkUser.getString(mail)).apply();
                        preferences.edit().putString("place", checkUser.getString(place)).apply();
                        preferences.edit().putString("passcode", checkUser.getString(passcode)).apply();
                        preferences.edit().putString("day_Register", checkUser.getString(dayRegister)).apply();
                        preferences.edit().putString("user_id", checkUser.getString(id)).apply();


                    } while (checkUser.moveToNext()); // THUS IT ONLY EXECUTES ONCE
                }

              // boolean logged= dataBaseHelper.loginCheck(username,password);
                Boolean check = checkUser.getCount()>0;

               if (check){
                   Toast.makeText(MainActivity.this, "login successful", Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(MainActivity.this,MyProfile.class);
                   startActivity(intent);
               }
               else {
                   Toast.makeText(MainActivity.this, "login not successful", Toast.LENGTH_SHORT).show();
               }
            }
        });

        mainRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this,RegisterUser.class);
                startActivity(intent);
            }
        });

    }
}