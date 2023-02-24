package com.example.dynamicfragment;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class tempActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_temp);

        if (savedInstanceState == null){
            MainActivity stopWatchFragment =  new MainActivity() ;

            FragmentTransaction ft = getSupportFragmentManager().beginTransaction();

            //ft.add()
            //ft.addToBackStack()
            //ft.setTransition()
            //ft.commit();
        }
    }
}