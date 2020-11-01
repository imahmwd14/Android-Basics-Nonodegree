package com.example.dervis.bandungguide;

import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.example.dervis.bandungguide.Data.ArchitecturalBuilding;
import com.example.dervis.bandungguide.Data.Hotel;
import com.example.dervis.bandungguide.Data.Park;
import com.example.dervis.bandungguide.Data.Restaurant;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        navigationView.setCheckedItem(R.id.nav_about_bandung);
        replaceFrameFragmentWith(new AboutFragment());
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        switch (id) {
            case R.id.nav_about_bandung:
                replaceFrameFragmentWith(new AboutFragment());
                break;
            case R.id.nav_hotels:
                replaceFrameFragmentWith(new HotelsFragment());
                break;
            case R.id.nav_restaurants:
                replaceFrameFragmentWith(new RestaurantsFragment());
                break;
            case R.id.nav_parks:
                replaceFrameFragmentWith(new ParksFragment());
                break;
            case R.id.nav_architectural:
                replaceFrameFragmentWith(new ArchitecturalBuildingsFragment());
                break;
        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void replaceFrameFragmentWith(Fragment fragment) {
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_frame, fragment).commit();
    }


    //the following methods each returns a list data about a specific attraction in Bandung
    public static List<ArchitecturalBuilding> GetListOfArchitecturalBuildings(Context context) {
        List<ArchitecturalBuilding> architecturalBuildings = new ArrayList<>();

        architecturalBuildings.add(new ArchitecturalBuilding(context.getString(R.string.architectural_1_name),
                context.getString(R.string.architectural_1_location),
                R.drawable.grand_mosque_bandung));

        architecturalBuildings.add(new ArchitecturalBuilding(context.getString(R.string.architectural_2_name),
                context.getString(R.string.architectural_2_location),
                R.drawable.gedung_sate));

        return architecturalBuildings;
    }

    public static List<Hotel> GetHotelsData(Context context) {
        ArrayList<Hotel> Hotels = new ArrayList<>();

        Hotels.add(new Hotel(context.getString(R.string.hotel_1_name),
                context.getString(R.string.hotel_1_location),
                context.getString(R.string.hotel_1_rating),
                context.getString(R.string.hotel_1_phone_number),
                context.getString(R.string.hotel_1_sevices),
                R.drawable.padma_hotel_bandung));

        Hotels.add(new Hotel(
                context.getString(R.string.hotel_2_name),
                context.getString(R.string.hotel_2_location),
                context.getString(R.string.hotel_2_rating),
                context.getString(R.string.hotel_2_phone_number),
                context.getString(R.string.hotel_2_sevices),
                R.drawable.trans_luxury_hotel_bandung));

        Hotels.add(new Hotel(
                context.getString(R.string.hotel_3_name),
                context.getString(R.string.hotel_3_location),
                context.getString(R.string.hotel_3_rating),
                context.getString(R.string.hotel_3_phone_number),
                context.getString(R.string.hotel_3_sevices),
                R.drawable.holiday_inn_bandung));

        return Hotels;
    }

    public static List<Park> GetListOfParks(Context context) {
        List<Park> parks = new ArrayList<>();

        parks.add(new Park(
                context.getString(R.string.park_1_name),
                context.getString(R.string.park_1_location),
                R.drawable.balai_kota_bandung));

        parks.add(new Park(
                context.getString(R.string.park_2_name),
                context.getString(R.string.park_2_location),
                R.drawable.peta_park));

        return parks;
    }

    public static List<Restaurant> GetRestaurantsData(Context context) {
        ArrayList<Restaurant> Restaurants = new ArrayList<>();

        Restaurants.add(new Restaurant(
                context.getString(R.string.restaurant_1_name),
                context.getString(R.string.restaurant_1_location),
                context.getString(R.string.restaurant_1_phone_number),
                R.drawable.hummingbird_eatery_bandung));

        Restaurants.add(new Restaurant(
                context.getString(R.string.restaurant_2_name),
                context.getString(R.string.restaurant_2_location),
                context.getString(R.string.restaurant_2_phone_number),
                R.drawable.the_restaurant_padma));

        Restaurants.add(new Restaurant(
                context.getString(R.string.restaurant_3_name),
                context.getString(R.string.restaurant_3_location),
                context.getString(R.string.restaurant_3_phone_number),
                R.drawable.the_restaurant_at_the_trans_luxury_hotel));

        return Restaurants;
    }
}
