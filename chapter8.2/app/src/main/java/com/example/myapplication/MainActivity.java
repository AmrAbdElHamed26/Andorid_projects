package com.example.myapplication;

import android.os.Bundle;
import android.widget.Toolbar;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

       // Toolbar toooolbar= (Toolbar) findViewById(R.id.tool_bar);
        //setSupportActionBar(toooolbar);
    }
}