package com.example.timeline_two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MyProfile extends AppCompatActivity {
    TextView u_name,fulName,email,place,phone,r_date;
    Button timelinePost,updatePortfolio;
    SharedPreferences dataBinder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);

        u_name = findViewById(R.id.my_username);
        fulName = findViewById(R.id.my_fullname);
        email = findViewById(R.id.my_email);
        place = findViewById(R.id.my_address);
        phone = findViewById(R.id.my_phone);
        r_date = findViewById(R.id.my_day_register);
        updatePortfolio = findViewById(R.id.my_profile_update);
        timelinePost = findViewById(R.id.my_profile_post);

        dataBinder = getSharedPreferences("preference", MODE_PRIVATE);
        String term1 = dataBinder.getString("userName", "");
        String term2 = dataBinder.getString("fullName", "");
        String term3 = dataBinder.getString("contactNum", "");
        String term4 = dataBinder.getString("mail", "");
        String term5 = dataBinder.getString("place", "");
        String term6 = dataBinder.getString("day_Register", "");

        u_name.setText(term1);
        fulName.setText(term2);
        email.setText(term4);
        place.setText(term5);
        phone.setText(term3);
        r_date.setText(term6);

        updatePortfolio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent changeProfile = new Intent(MyProfile.this,Portfolio_update.class);
                startActivity(changeProfile);
            }
        });

        timelinePost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent goToTimeline = new Intent(MyProfile.this,GeneralTimeline.class);
                startActivity(goToTimeline);
            }
        });



    }

}