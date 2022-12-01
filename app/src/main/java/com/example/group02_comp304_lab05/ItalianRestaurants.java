package com.example.group02_comp304_lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;

public class ItalianRestaurants extends AppCompatActivity {

    //ImageView image1,image2,image3;
    ListView restaurantList;
    String[] restaurants ={"La Vecchia Restaurant Uptown","Grazie Ristorante", "Donatello Restaurant"};
    String address;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_italian_restaurants);
        setTitle("Italian Restaurants");


        restaurantList = findViewById(R.id.italianList);


        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this,
                R.layout.activity_restaurant, R.id.textView_name, restaurants);
        restaurantList.setAdapter(arrayAdapter);

        restaurantList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selected = restaurantList.getItemAtPosition(position).toString();

                if(selected.equals("La Vecchia Restaurant Uptown")){
                    address = "2373 Yonge St, Toronto, ON M4P 2C8";
                    loadMap(view);
                }
                if(selected.equals("Grazie Ristorante")){

                    address = "2405 Yonge St A, Toronto, ON M4P 2E7";
                    loadMap(view);
                }
                if(selected.equals("Donatello Restaurant")){
                    address = "37 Elm St, Toronto, ON M5G 1H1";
                    loadMap(view);
                }
            }
        });
    }

        /*image1 = findViewById(R.id.italianRestaurant1);
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
    }*/

    public void loadMap(View view){
        Intent intent = new Intent(this, MapsActivity.class);
        intent.putExtra("Address", address);
        startActivity(intent);
    }
}