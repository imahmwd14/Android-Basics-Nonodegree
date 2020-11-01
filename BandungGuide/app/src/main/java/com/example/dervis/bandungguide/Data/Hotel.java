package com.example.dervis.bandungguide.Data;

//this is the data class for a hotel object
public class Hotel {
    //due to the simple nature of this app, the concept of encapsulation won't be applied!
    public String Name, Location, Rating, PhoneNumber, Services;
    public int DrawableResId;

    public Hotel(String name, String location, String rating, String phoneNumber, String services, int drawableResId) {
        Name = name;
        Location = location;
        Rating = rating;
        PhoneNumber = phoneNumber;
        Services = services;
        DrawableResId = drawableResId;
    }
}

