package com.example.workoutpart2;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class workoutDetailsfragment extends Fragment {

    private long id ;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if(savedInstanceState != null){
            id = savedInstanceState.getLong("ID");
        }
    }

    @Override
    public void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putLong("ID" , id);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detailsfragment, container, false);
    }
    public void onStart() {

        super.onStart();
        View view =(View) getView();
        if (view != null){
            TextView titleTextView = (TextView) view.findViewById(R.id.title_id);
            TextView description  = (TextView) view.findViewById(R.id.description_id);

            Workout workout = Workout.workouts[(int)id];

            titleTextView.setText(workout.getName());
            description.setText(workout.getDescription());
        }
    }
    public void setWorkoutId(long id){
        this.id=id;
    }
}