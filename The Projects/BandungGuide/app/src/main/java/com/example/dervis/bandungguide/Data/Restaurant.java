package com.example.dervis.bandungguide.Data;


//this is the data class for a restaurant object
public class Restaurant {
    //due to the simple nature of this app, the concept of encapsulation won't be applied!
    public String Name, Location, PhoneNumber;
    public int DrawableResId;

    public Restaurant(String name, String location, String phoneNumber, int drawableResId) {
        Name = name;
        Location = location;
        PhoneNumber = phoneNumber;
        DrawableResId = drawableResId;
    }
}
