package com.example.workout;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class DetailActivity extends AppCompatActivity {

    public static final String EXTRA_WORKOUT_ID = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        WorkoutDetailFragment frag = (WorkoutDetailFragment) getSupportFragmentManager().findFragmentById(R.id.detail_fragment);
                /* take refrence for the fragment which show the details ,
                   it is the view but we use it using ----> getSupportFragmentManager
                */




        if (EXTRA_WORKOUT_ID == "" )            // this condition for fragment
             frag.setWorkout(1);                // using public method to access the id for the object in the array
        else {                                  // this for list fragment
            int workoutId = (int) getIntent().getExtras().get(EXTRA_WORKOUT_ID);
            frag.setWorkout(workoutId);
        }
    }
}