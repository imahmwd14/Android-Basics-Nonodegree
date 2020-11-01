package com.example.dervis.musicplayer;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class SongsAdapter extends RecyclerView.Adapter<SongsAdapter.ViewHolder> {

    private List<Song> Songs;

    public SongsAdapter(List<Song> songs) {
        Songs = songs;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        final ViewHolder vH = new ViewHolder(LayoutInflater.from(parent.getContext())
                .inflate(R.layout.sample_song, parent, false));

        vH.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MainActivity.CurrentlySelected = Songs.get(vH.getAdapterPosition());
                v.getContext().startActivity(new Intent(v.getContext(), SongDetails.class));
            }
        });

        return vH;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Song song = Songs.get(position);

        holder.SongTitle.setText(song.Title);
        holder.ArtistName.setText(song.ArtistName);
        holder.Duration.setText(song.Duration);
        holder.CoverArt.setImageResource(song.CoverArtResId);
    }

    @Override
    public int getItemCount() {
        return Songs.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView ArtistName;
        TextView SongTitle;
        TextView Duration;
        ImageView CoverArt;

        public ViewHolder(View itemView) {
            super(itemView);

            SongTitle = itemView.findViewById(R.id.song_title);
            ArtistName = itemView.findViewById(R.id.artist_name);
            Duration = itemView.findViewById(R.id.duration);
            CoverArt = itemView.findViewById(R.id.cover_art);
        }
    }
}
