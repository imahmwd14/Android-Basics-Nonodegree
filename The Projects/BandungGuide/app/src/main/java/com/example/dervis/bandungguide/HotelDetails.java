package com.example.dervis.bandungguide;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.dervis.bandungguide.Data.Hotel;

//this activity shows details about a specific hotel
public class HotelDetails extends AppCompatActivity {

    public static final String HOTELS_LIST_INDEX_PARAM = "1";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_details);

        Hotel hotel = MainActivity.GetHotelsData(this).get(getIntent().getExtras().getInt(HOTELS_LIST_INDEX_PARAM));

        ((TextView) findViewById(R.id.textViewName)).setText(hotel.Name);
        ((TextView) findViewById(R.id.phoneNumber)).setText(hotel.PhoneNumber);
        ((TextView) findViewById(R.id.rating)).setText(hotel.Rating);
        ((TextView) findViewById(R.id.services)).setText(hotel.Services);
        ((TextView) findViewById(R.id.location)).setText(hotel.Location);

        ((ImageView) findViewById(R.id.imageView)).setImageResource(hotel.DrawableResId);
    }
}
