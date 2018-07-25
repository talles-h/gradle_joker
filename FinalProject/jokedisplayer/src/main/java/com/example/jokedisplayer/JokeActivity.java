package com.example.jokedisplayer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokeActivity extends AppCompatActivity {

    public static String EXTRA_JOKE = "joke";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joke);

        TextView jokeTextView = findViewById(R.id.text_view_joke);

        Intent intent = getIntent();
        if (intent != null) {
            String joke = intent.getStringExtra(EXTRA_JOKE);
            if (joke != null && joke.length() != 0) {
                jokeTextView.setText(joke);
            }
        }
    }
}
