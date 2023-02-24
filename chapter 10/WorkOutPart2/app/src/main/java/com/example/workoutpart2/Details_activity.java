package com.example.workoutpart2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Details_activity extends AppCompatActivity {

    public static final String WORKOUT_ID ="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        workoutDetailsfragment workoutDetailsfragment = (workoutDetailsfragment) getSupportFragmentManager().findFragmentById(R.id.detailed_fragmenr_id);


        int workoutId = (int)getIntent().getExtras().get(WORKOUT_ID);



        workoutDetailsfragment.setWorkoutId(workoutId);
    }
}