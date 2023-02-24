package com.example.caffeapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class DrinkActivity extends AppCompatActivity {

    public  static final String EXTRA_DRINKID ="" ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink);

        int drinkId = (Integer ) getIntent().getExtras().get( EXTRA_DRINKID) ;

        Drinks drink = Drinks.drinks[drinkId];


        TextView txtView1 =(TextView) findViewById(R.id.txt_view_1);
        TextView txtView2 = (TextView)findViewById(R.id.txt_view_2);
        ImageView imageView = (ImageView)findViewById(R.id.image_id);



        txtView1.setText(drink.getName());
        txtView2.setText(drink.getDescription());
        imageView.setImageResource(drink.getImage());
        imageView.setContentDescription(drink.getName());

    }
}