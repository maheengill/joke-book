package com.example.jokebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import pl.droidsonroids.gif.GifImageView;

public class MainActivity extends AppCompatActivity {

    GifImageView gifImageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        gifImageView = findViewById(R.id.gifImageView);

        gifImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(MainActivity.this, CategoriesActivity.class);
                startActivity(i);
            }
        });
    }
}