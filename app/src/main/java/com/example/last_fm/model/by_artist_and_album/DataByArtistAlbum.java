package com.example.last_fm.model.by_artist_and_album;

import com.google.gson.annotations.SerializedName;

public class DataByArtistAlbum {

    @SerializedName("album")
    private AlbumByArtistAlbum album;

    public DataByArtistAlbum(AlbumByArtistAlbum album) {
        this.album = album;
    }

    public AlbumByArtistAlbum getAlbum() {
        return album;
    }

    public void setAlbum(AlbumByArtistAlbum album) {
        this.album = album;
    }
}
