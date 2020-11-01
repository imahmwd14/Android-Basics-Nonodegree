package com.example.dervis.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import org.w3c.dom.Text;

public class SongDetails extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_song_details);

        findViewById(R.id.cover_art).setVisibility(View.GONE);

        if (MainActivity.CurrentlySelected != null) {
            ((TextView) findViewById(R.id.song_title)).setText(MainActivity.CurrentlySelected.Title);
            ((TextView) findViewById(R.id.artist_name)).setText(MainActivity.CurrentlySelected.ArtistName);
            ((TextView) findViewById(R.id.duration)).setText(MainActivity.CurrentlySelected.Duration);
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.music_queue:
                startActivity(new Intent(this, MusicQueue.class));
                break;
        }
        return true;
    }

    public void addSongToQueue(View view) {
        MainActivity.MusicQueue.add(MainActivity.CurrentlySelected);
    }

    public void addSongAfterClearingQueue(View view) {
        MainActivity.MusicQueue.clear();
        MainActivity.MusicQueue.add(MainActivity.CurrentlySelected);
    }
}
