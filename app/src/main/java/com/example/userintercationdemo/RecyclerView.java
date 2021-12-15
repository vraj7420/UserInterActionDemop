   package com.example.userintercationdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;

public class RecyclerView extends AppCompatActivity {
     private androidx.recyclerview.widget.RecyclerView  recyclerView;
     private String petName[];
     private String petDesc[];
     private int imgResource[]={R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background,R.drawable.ic_launcher_background};
     RecyclerViewAdapter adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        recyclerView=(androidx.recyclerview.widget.RecyclerView)findViewById(R.id.revForDemo);
        petName=getResources().getStringArray(R.array.petName);
        petDesc=getResources().getStringArray(R.array.desc);
        adapter=new RecyclerViewAdapter(RecyclerView.this,petName,petDesc,imgResource);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(RecyclerView.this));

    }
}