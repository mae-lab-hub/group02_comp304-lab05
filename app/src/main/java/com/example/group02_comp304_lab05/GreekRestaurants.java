package com.example.group02_comp304_lab05;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;

public class GreekRestaurants extends AppCompatActivity {

    ImageView image1,image2,image3;

    String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greek_restaurants);
        setTitle("Greek Restaurants");

        image1 = findViewById(R.id.greekRestaurant1);
        image2 = findViewById(R.id.greekRestaurant2);
        image3 = findViewById(R.id.greekRestaurant3);


        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address = "456 Danforth Ave, Toronto, ON M4K 1P3";
                loadMap(view);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address = "133 Richmond St W, Toronto, ON M5H 2L3";
                loadMap(view);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address = "2048 Avenue Rd, North York, ON M5M 4A6";
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