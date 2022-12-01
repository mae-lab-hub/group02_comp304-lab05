package com.example.group02_comp304_lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class ChineseRestaurants extends AppCompatActivity {

    //ImageView image1,image2,image3;
    ListView restaurantList;
    String[] restaurants ={"Swatow Restaurant","Hong Shing Restaurant", "Lee Chen Asian Bistro"};
    String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_chinese_restaurants);
        setTitle("Chinese Restaurants");


        restaurantList = findViewById(R.id.chineseList);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.activity_restaurant, R.id.textView_name, restaurants);
        restaurantList.setAdapter(arrayAdapter);

        restaurantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selected = restaurantList.getItemAtPosition(position).toString();

                if(selected.equals("Swatow Restaurant")){
                    address = "309 Spadina Ave., Toronto, ON M5T 1H1";
                    loadMap(view);
                }
                if(selected.equals("Hong Shing Restaurant")){

                    address = "195 Dundas St W, Toronto, ON M5G 1C7";
                    loadMap(view);
                }
                if(selected.equals("Lee Chen Asian Bistro")){
                    address = "214 King St W, Toronto, ON M5H 3S6";
                    loadMap(view);
                }
            }
        });
    }
        /*
        image1 = findViewById(R.id.chineseRestaurant1);
        image2 = findViewById(R.id.chineseRestaurant2);
        image3 = findViewById(R.id.chineseRestaurant3);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address = "195 Dundas St W, Toronto, ON M5G 1C7";
                loadMap(view);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address = "309 Spadina Ave., Toronto, ON M5T 1H1";
                loadMap(view);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address = "214 King St W, Toronto, ON M5H 3S6";
                loadMap(view);
            }
        });*/


    public void loadMap(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("Address", address);
        startActivity(intent);
    }
}