package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class Activityforlistfra extends AppCompatActivity implements Listener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activityforlistfra);
    }

    @Override
    public void itemClicked(int id) {
        Intent intent = new Intent(this , DetailActivity.class);
        intent.putExtra(DetailActivity.EXTRA_WORKOUT_ID, (int)id);
        startActivity(intent);
    }
}