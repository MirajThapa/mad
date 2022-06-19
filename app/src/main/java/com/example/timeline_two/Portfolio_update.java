package com.example.timeline_two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Portfolio_update extends AppCompatActivity {
    private EditText userName,fullName,mail,place1,phone;
    Button updatePortfolio;
    SharedPreferences dataBinder;
    DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
    String uName,fulName,e_mail,place,contact,_id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_portfolio_update);

        userName = findViewById(R.id.activity_updateUser_username);
        fullName = findViewById(R.id.activity_updateUser_fullname);
        mail = findViewById(R.id.activity_updateUser_email);
        place1 = findViewById(R.id.activity_updateUser_address);
        phone = findViewById(R.id.activity_updateUser_phone);

        updatePortfolio = findViewById(R.id.activity_updateUser_r_btn);

        dataBinder = getSharedPreferences("preference", Context.MODE_PRIVATE);     // GETS THE DECLARED PREFERENCES
        userName.setText(dataBinder.getString("userName", ""));
        fullName.setText(dataBinder.getString("fullName", ""));
        mail.setText(dataBinder.getString("mail", ""));
        place1.setText(dataBinder.getString("place", ""));
        phone.setText(dataBinder.getString("contactNum", ""));
        _id = dataBinder.getString("user_id", "");


        updatePortfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                uName = userName.getText().toString();
                fulName = fullName.getText().toString();
                e_mail = mail.getText().toString();
                place = place1.getText().toString();
                contact = phone.getText().toString();
                Log.i("updateid", _id);

                dataBinder.edit().putString("userName", uName).apply();
                dataBinder.edit().putString("fullName", fulName).apply();
                dataBinder.edit().putString("mail", e_mail).apply();
                dataBinder.edit().putString("place", place).apply();
                dataBinder.edit().putString("place", contact).apply();


                dataBaseHelper.updateIndividual(uName,fulName,e_mail,contact,place,_id);
                Intent throwToProfile = new Intent(Portfolio_update.this,MyProfile.class);
                startActivity(throwToProfile);
            }
        });



    }
}