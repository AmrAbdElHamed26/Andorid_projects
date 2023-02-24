package com.example.dynamicfragment;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends Fragment implements View.OnClickListener{

    private int seconds = 0 ;
    private boolean running = false ;
    private boolean wasRunning ;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_main);   /*You don’t set a fragment’s layoutin its onCreate() method.*/
        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning =savedInstanceState.getBoolean("wasRunning");
        }


         // runTimer();
                            /* We’re not calling runTimer() yet because we’ve
                                not set the layout—we don’t have any views yet.*/



    }

    @Override
    public void onSaveInstanceState( Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("running", running);
        outState.putBoolean("wasRunning" , wasRunning);
    }

    private void runTimer (View view){

        TextView txt_time = view.findViewById(R.id.txt_counter);
        final Handler handler = new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {

                int hours = seconds / 3600 ;
                int min = (seconds % 3600) / 60 ;
                int secs = seconds % 60 ;

                String time = String.format(Locale.getDefault(), "%d:%02d:%02d", hours, min, secs);

                txt_time.setText(time);

                if (running)
                    seconds ++ ;

                handler.postDelayed(this , 1000);

            }
        }) ;


    }

    @Override
    public void onStop() {
        super.onStop();
        wasRunning = running ;
        running = false;
    }

    @Override
    public void onStart() {
        super.onStart();

        if (wasRunning)
            running = true ;
    }
    private void setOnClicStart() {

        running = true;
    }


    private void setOnClickReset() {

        seconds = 0 ;

    }
    private void setOnClickStop() {


        running = false ;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.activity_main, container, false);
        runTimer(layout);

        Button startButton = (Button) layout.findViewById(R.id.btn_start);
        Button stopButton = (Button) layout.findViewById(R.id.btn_stop);
        Button resettButton = (Button) layout.findViewById(R.id.btn_reset);


        startButton.setOnClickListener(this);
        stopButton.setOnClickListener(this);
        resettButton.setOnClickListener(this);


        return layout ;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_start:
                setOnClicStart();
                break;
            case R.id.btn_reset:
                setOnClickReset();
                break;
            case R.id.btn_stop:
                setOnClickStop();
                break;

        }
    }
}