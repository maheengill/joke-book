package com.example.jokebook;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    TextView jokeTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        Intent intent = getIntent();
        String joke = intent.getStringExtra("joke");

        jokeTextView = findViewById(R.id.textView2);
        jokeTextView.setText(joke);

    }
}