package com.example.dervis.musicplayer;

import java.util.ArrayList;
import java.util.List;

class Song {
    String Title;
    String ArtistName;
    String Duration;
    int CoverArtResId;

    public Song(String title, String artistName, String duration, int coverArtResId) {
        Title = title;
        ArtistName = artistName;
        Duration = duration;
        CoverArtResId = coverArtResId;
    }

    public static List<Song> GetDummyList() {
        List<Song> Songs = new ArrayList<>();

        Songs.add(new Song("title1", "artist1", "4:12", R.drawable.ic_music_note_black_24dp));
        Songs.add(new Song("title2", "artist1", "5:14", R.drawable.ic_music_note_black_24dp));
        Songs.add(new Song("title3", "artist1", "4:11", R.drawable.ic_music_note_black_24dp));
        Songs.add(new Song("title4", "artist2", "4:16", R.drawable.ic_music_note_black_24dp));
        Songs.add(new Song("title5", "artist2", "4:13", R.drawable.ic_music_note_black_24dp));
        Songs.add(new Song("title6", "artist2", "5:36", R.drawable.ic_music_note_black_24dp));
        Songs.add(new Song("title7", "artist3", "4:12", R.drawable.ic_music_note_black_24dp));
        Songs.add(new Song("title8", "artist3", "6:15", R.drawable.ic_music_note_black_24dp));
        Songs.add(new Song("title9", "artist3", "4:10", R.drawable.ic_music_note_black_24dp));
        Songs.add(new Song("title10", "artist4", "4:10", R.drawable.ic_music_note_black_24dp));
        Songs.add(new Song("title11", "artist4", "3:17", R.drawable.ic_music_note_black_24dp));
        Songs.add(new Song("title12", "artist4", "4:32", R.drawable.ic_music_note_black_24dp));
        Songs.add(new Song("title13", "artist5", "2:12", R.drawable.ic_music_note_black_24dp));
        Songs.add(new Song("title14", "artist5", "4:23", R.drawable.ic_music_note_black_24dp));
        Songs.add(new Song("title15", "artist5", "1:12", R.drawable.ic_music_note_black_24dp));
        Songs.add(new Song("title16", "artist6", "4:56", R.drawable.ic_music_note_black_24dp));
        Songs.add(new Song("title17", "artist6", "2:23", R.drawable.ic_music_note_black_24dp));
        Songs.add(new Song("title18", "artist6", "3:28", R.drawable.ic_music_note_black_24dp));
        Songs.add(new Song("title19", "artist7", "5:19", R.drawable.ic_music_note_black_24dp));

        return Songs;
    }
}
