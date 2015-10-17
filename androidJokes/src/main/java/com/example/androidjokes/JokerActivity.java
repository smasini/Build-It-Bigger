package com.example.androidjokes;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class JokerActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_joker);

        TextView joke = (TextView) findViewById(R.id.textview_joke);
        Intent intent = getIntent();
        if(intent.hasExtra(getString(R.string.extra_joke)))
            joke.setText(intent.getStringExtra(getString(R.string.extra_joke)));
    }
}
