package com.example.last_fm.model.by_artist;

import com.google.gson.annotations.SerializedName;

public class DataByArtist {

    @SerializedName("topalbums")
    private TopAlbumsByArtist topAlbumsByArtist;

    public DataByArtist(TopAlbumsByArtist topAlbumsByArtist) {
        this.topAlbumsByArtist = topAlbumsByArtist;
    }

    public TopAlbumsByArtist getTopAlbumsByArtist() {
        return topAlbumsByArtist;
    }

    public void setTopAlbumsByArtist(TopAlbumsByArtist topAlbumsByArtist) {
        this.topAlbumsByArtist = topAlbumsByArtist;
    }
}
