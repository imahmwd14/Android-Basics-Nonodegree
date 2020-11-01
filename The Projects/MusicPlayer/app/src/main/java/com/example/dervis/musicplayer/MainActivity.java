package com.example.dervis.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    // this list will be used as way to pass data between multiple activities
    public static List<Song> MusicQueue = new ArrayList<>();

    //this will store the song that is being viewed
    static Song CurrentlySelected = null;

    //this view is used to list the songs.
    RecyclerView songsRecyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        songsRecyclerView = findViewById(R.id.recyclerView);

        songsRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        songsRecyclerView.setAdapter(new SongsAdapter(Song.GetDummyList()));

        Toast.makeText(this, "To View The Music Queue Please Click \nOn The Icon At The Top-Right Corner", Toast.LENGTH_LONG).show();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        //the menu has one option that is the music queue
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.music_queue:
                //show the queue
                startActivity(new Intent(this, MusicQueue.class));
                break;
        }
        return true;
    }
}
