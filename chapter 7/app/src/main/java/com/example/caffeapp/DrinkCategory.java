package com.example.caffeapp;

import static com.example.caffeapp.Drinks.drinks;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class DrinkCategory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drink_category);

        ListView listView = (ListView) findViewById(R.id.list_drinks_id) ;

        ArrayAdapter<Drinks> arrayAdapter = new ArrayAdapter<>(this ,
                                            android.R.layout.simple_list_item_1,
                                            Drinks.drinks) ;

        listView.setAdapter(arrayAdapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(DrinkCategory.this , DrinkActivity.class);
                intent.putExtra(DrinkActivity.EXTRA_DRINKID , (int)id );
                startActivity(intent);
            }
        });

    }
}