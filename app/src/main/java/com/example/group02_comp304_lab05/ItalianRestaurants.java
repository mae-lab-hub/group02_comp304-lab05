package com.example.group02_comp304_lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class ItalianRestaurants extends AppCompatActivity {

    ImageView image1,image2,image3;

    String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italian_restaurants);
        setTitle("Italian Restaurants");

        image1 = findViewById(R.id.italianRestaurant1);
        image2 = findViewById(R.id.italianRestaurant2);
        image3 = findViewById(R.id.italianRestaurant3);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address = "2405 Yonge St A, Toronto, ON M4P 2E7";
                loadMap(view);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address = "2373 Yonge St, Toronto, ON M4P 2C8";
                loadMap(view);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address = "37 Elm St, Toronto, ON M5G 1H1";
                loadMap(view);
            }
        });
    }

    public void loadMap(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("Address", address);
        startActivity(intent);
    }
}