package com.example.timeline_two;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class AddPost extends AppCompatActivity {
    EditText descPost;
    Button back,post_content;
    DataBaseHelper dataBaseHelper = new DataBaseHelper(this);
    SharedPreferences bindData;
    String name,describe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_post);

        descPost = findViewById(R.id.add_post_content);
        post_content = findViewById(R.id.add_post_btn);
        back = findViewById(R.id.add_post_back);
        bindData = getSharedPreferences("preference", Context.MODE_PRIVATE);

        name = bindData.getString("fullName", "");

        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat formate1 =new SimpleDateFormat("dd-MM-yyyy");
        String day = formate1.format(calendar.getTime());

        post_content.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                describe = descPost.getText().toString();
                dataBaseHelper.contentAdd(name,describe,day);

                Toast.makeText(AddPost.this, "Posted Successfully", Toast.LENGTH_SHORT).show();
                Intent toPost = new Intent(AddPost.this,GeneralTimeline.class);
                startActivity(toPost);
            }
        });

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

    }
}