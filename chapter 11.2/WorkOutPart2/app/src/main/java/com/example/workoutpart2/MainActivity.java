package com.example.workoutpart2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements Listener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public void itemClicked(long id) {

        View fragmnetContainer = findViewById(R.id.fragment);

        if(fragmnetContainer!=null){
                // add the fragment to the framelayout

            workoutDetailsfragment workoutDetailsfragment = new workoutDetailsfragment() ;
            FragmentTransaction fragmentTransaction = getSupportFragmentManager().beginTransaction();
            workoutDetailsfragment.setWorkoutId(id);

            fragmentTransaction.replace(R.id.fragment , workoutDetailsfragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.addToBackStack(null);
            fragmentTransaction.commit();


        }else{
            Intent intent = new Intent(this , Details_activity.class);
            intent.putExtra(Details_activity.WORKOUT_ID , (int)id);
            startActivity(intent);
        }

    }
}