package com.example.workout;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.os.TestLooperManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class WorkoutDetailFragment extends Fragment {

    private int workoutId ;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_workout_detail, container, false);
    }

    @Override
    public void onStart() {
        super.onStart();
        View view = getView();

        Workout workout= Workout.workouts[workoutId];    // to take refrence for the object in the array which index is ----> workoutId

        TextView title = (TextView) view.findViewById(R.id.textView2);
        title.setText(workout.getName());

        TextView description = (TextView) view.findViewById(R.id.textView) ;
        description.setText(workout.getDescription());

    }

    public void setWorkout(int id){
        this.workoutId = id ;
    }
}