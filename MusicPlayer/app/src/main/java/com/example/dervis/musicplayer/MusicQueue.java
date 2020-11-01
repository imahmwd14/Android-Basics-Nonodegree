package com.example.dervis.musicplayer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

public class MusicQueue extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_music_queue);

        RecyclerView musicQueue = findViewById(R.id.music_queue_recycler_view);

        musicQueue.setLayoutManager(new LinearLayoutManager(this));

        //if the music queue list is empty the empty-queue-message is kept visible
        if (MainActivity.MusicQueue.size() > 0) {
            findViewById(R.id.empty_queue_message).setVisibility(View.GONE);
            findViewById(R.id.music_queue_recycler_view).setVisibility(View.VISIBLE);
        }

        musicQueue.setAdapter(new SongsAdapter(MainActivity.MusicQueue));
    }
}
