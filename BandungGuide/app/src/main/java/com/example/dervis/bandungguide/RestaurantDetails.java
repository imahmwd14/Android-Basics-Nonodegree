package com.example.dervis.bandungguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dervis.bandungguide.Data.Restaurant;

//this activity shows details about a specific restaurant
public class RestaurantDetails extends AppCompatActivity {

    public static final String RESTAURANTS_LIST_INDEX_PARAM = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurant_details);

        Restaurant restaurant = MainActivity.GetRestaurantsData(this).get(getIntent().getExtras()
                .getInt(RESTAURANTS_LIST_INDEX_PARAM));

        ((TextView) findViewById(R.id.name)).setText(restaurant.Name);
        ((TextView) findViewById(R.id.location)).setText(restaurant.Location);
        ((TextView) findViewById(R.id.phoneNumber)).setText(restaurant.PhoneNumber);

        ((ImageView) findViewById(R.id.image)).setImageResource(restaurant.DrawableResId);
    }
}
