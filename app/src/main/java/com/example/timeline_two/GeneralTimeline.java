package com.example.timeline_two;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class GeneralTimeline extends AppCompatActivity {
    RecyclerView postSection;
    Button add_post;
    ArrayList<Timeline> allDatas;
    DataBaseHelper dataBaseHelper = new DataBaseHelper(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_general_timeline);

        add_post = findViewById(R.id.general_timeline_add);
        postSection = findViewById(R.id.general_timeline_posts);
        postSection.setLayoutManager(new LinearLayoutManager(this));
        allDatas = new ArrayList<Timeline>();
        Cursor data = dataBaseHelper.allPosts();

        while (data.moveToNext()){
            Timeline object = new Timeline(data.getString(1),data.getString(2),data.getString(3));
            allDatas.add(object);
        }

        Adapter adapter = new Adapter(allDatas);
        postSection.setAdapter(adapter);

        add_post.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent add = new Intent(GeneralTimeline.this,AddPost.class);
                startActivity(add);
            }
        });
    }
}