package com.example.dervis.bandungguide.Data;

public class Park {
    //due to the simple nature of this app, the concept of encapsulation won't be applied!
    public String Name, Location;
    public int DrawableResId;

    public Park(String name, String location, int drawableResId) {
        Name = name;
        Location = location;
        DrawableResId = drawableResId;
    }
}
