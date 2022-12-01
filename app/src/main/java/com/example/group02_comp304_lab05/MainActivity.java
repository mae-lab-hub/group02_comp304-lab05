package com.example.group02_comp304_lab05;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CompoundButton;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    ListView cuisineList;
    String cuisineTypes[] = {"Italian", "Greek", "Chinese", "Indian"};


    ListView restaurantList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        cuisineList = findViewById(R.id.cuisineList);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(this, R.layout.activity_cuisine_list, R.id.textView, cuisineTypes);
        cuisineList.setAdapter(arrayAdapter);



        cuisineList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                String selected = cuisineList.getItemAtPosition(position).toString();
                //Toast.makeText(MainActivity.this, selected, Toast.LENGTH_SHORT).show();

                if(selected.equals("Italian")){
                    loadItalianRestaurantsList(view);
                }
                if(selected.equals("Greek")){
                    Log.i("Find", "In the if greek restaurant");
                    loadGreekRestaurantsList(view);
                }
                if(selected.equals("Chinese")){
                    loadChineseRestaurantsList(view);
                }
                if(selected.equals("Indian")){
                    loadIndianRestaurantsList(view);
                }
            }
        });
    }

    public void loadItalianRestaurantsList(View view){
        Intent intent = new Intent(this, ItalianRestaurants.class);
        startActivity(intent);
    }
    public void loadGreekRestaurantsList(View view){
        Intent intent = new Intent(this, GreekRestaurants.class);
        startActivity(intent);
    }
    public void loadChineseRestaurantsList(View view){
        Intent intent = new Intent(this, ChineseRestaurants.class);

        startActivity(intent);
    }
    public void loadIndianRestaurantsList(View view){
        Intent intent = new Intent(this, IndianRestaurants.class);
        startActivity(intent);
    }
}