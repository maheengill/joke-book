package com.example.jokebook;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class CategoriesActivity extends AppCompatActivity {

    CardView generalCV, knockKnockCV, programmingCV;
    DBHelper db;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categories);
        getSupportActionBar().hide();

        db = new DBHelper(CategoriesActivity.this);

        generalCV = findViewById(R.id.general);
        knockKnockCV = findViewById(R.id.knockKnock);
        programmingCV = findViewById(R.id.programming);

        generalCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String joke = db.getGeneralJoke();
                Intent i = new Intent(CategoriesActivity.this, JokeActivity.class);
                i.putExtra("joke", joke);
                i.putExtra("category", "General");
                startActivity(i);
            }
        });

        knockKnockCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String joke = db.getKnockKnockJoke();
                Intent i = new Intent(CategoriesActivity.this, JokeActivity.class);
                i.putExtra("joke", joke);
                i.putExtra("category", "Knock-Knock");
                startActivity(i);
            }
        });

        programmingCV.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String joke = db.getProgrammingJoke();
                Intent i = new Intent(CategoriesActivity.this, JokeActivity.class);
                i.putExtra("joke", joke);
                i.putExtra("category", "Programming");
                startActivity(i);
            }
        });
    }
}