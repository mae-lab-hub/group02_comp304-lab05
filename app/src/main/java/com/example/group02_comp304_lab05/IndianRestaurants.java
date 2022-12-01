package com.example.group02_comp304_lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class IndianRestaurants extends AppCompatActivity {

    ListView restaurantList;
    String[] restaurants ={"Raj Mahal Indian Cuisin","Leela Indian Food Bar", "Marigold Indian Bistro"};
    String address;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indian_restaurants);
        setTitle("Indian Restaurants");

        restaurantList = findViewById(R.id.indianList);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.activity_restaurant, R.id.textView_name, restaurants);
        restaurantList.setAdapter(arrayAdapter);

        restaurantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selected = restaurantList.getItemAtPosition(position).toString();

                if(selected.equals("Raj Mahal Indian Cuisine")){
                    address = "1386 Gerrard St E, Toronto, ON M4L 1Z2";
                    loadMap(view);
                }
                if(selected.equals("Leela Indian Food Bar")){

                    address = "Dufferin Corners, 1881 Steeles Ave W, Toronto, ON M3H 5Y4";
                    loadMap(view);
                }
                if(selected.equals("Marigold Indian Bistro")){
                    address = "552 Mt Pleasant Rd, Toronto, ON M4S 2M6";
                    loadMap(view);
                }
            }
        });
    }
       /* image1 = findViewById(R.id.indianRestaurant1);
        image2 = findViewById(R.id.indianRestaurant2);
        image3 = findViewById(R.id.indianRestaurant3);

        image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address = "1386 Gerrard St E, Toronto, ON M4L 1Z2";
                loadMap(view);
            }
        });

        image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address = "Dufferin Corners, 1881 Steeles Ave W, Toronto, ON M3H 5Y4";
                loadMap(view);
            }
        });

        image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                address = "552 Mt Pleasant Rd, Toronto, ON M4S 2M6";
                loadMap(view);
            }
        });
    }*/

    public void loadMap(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("Address", address);
        startActivity(intent);
    }
}