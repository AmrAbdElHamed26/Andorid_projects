package com.example.stopwatch;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    private int seconds = 0 ;
    private boolean running = false ;
    private boolean wasRunning ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (savedInstanceState != null) {
            seconds = savedInstanceState.getInt("seconds");
            running = savedInstanceState.getBoolean("running");
            wasRunning =savedInstanceState.getBoolean("wasRunning");
        }
        setContentView(R.layout.activity_main);
        Button btn_start = findViewById(R.id.btn_start);
        Button btn_reset = findViewById(R.id.btn_reset) ;
        Button btn_stop = findViewById(R.id.btn_stop) ;


        runTimer();


        btn_start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = true;
            }
        });

        btn_reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                seconds = 0 ;

            }
        });

        btn_stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                running = false ;
            }
        });
    }

    @Override
    protected void onSaveInstanceState( Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt("seconds", seconds);
        outState.putBoolean("running", running);
        outState.putBoolean("wasRunning" , wasRunning);
    }

    private void runTimer (){

        TextView txt_time = findViewById(R.id.txt_counter);
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
    protected void onStop() {
        super.onStop();
        wasRunning = running ;
        running = false;
    }

    @Override
    protected void onStart() {
        super.onStart();

        if (wasRunning)
            running = true ;
    }
}