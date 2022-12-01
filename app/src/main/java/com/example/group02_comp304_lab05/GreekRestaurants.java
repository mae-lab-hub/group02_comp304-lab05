package com.example.group02_comp304_lab05;


import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class GreekRestaurants extends AppCompatActivity {

    ListView restaurantList;
    String[] restaurants ={"Volos Greek Cuisine","Mezes", "Karbouzi"};
    String address;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_greek_restaurants);
        setTitle("Greek Restaurants");


        restaurantList = findViewById(R.id.greekList);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.activity_restaurant, R.id.textView_name, restaurants);
        restaurantList.setAdapter(arrayAdapter);

        restaurantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selected = restaurantList.getItemAtPosition(position).toString();

                if(selected.equals("Volos Greek Cuisine")){
                    address = "133 Richmond St W, Toronto, ON M5H 2L3";
                    loadMap(view);
                }
                if(selected.equals("Mezes")){

                    address = "456 Danforth Ave, Toronto, ON M4K 1P3";
                    loadMap(view);
                }
                if(selected.equals("Karbouzi")){
                    address = "2048 Avenue Rd, North York, ON M5M 4A6";
                    loadMap(view);
                }
            }
        });
    }

    public void loadMap(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("Address", address);
        startActivity(intent);
    }
}