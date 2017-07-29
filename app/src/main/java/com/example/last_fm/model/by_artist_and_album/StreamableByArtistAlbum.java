package com.example.last_fm.model.by_artist_and_album;

import com.google.gson.annotations.SerializedName;

class StreamableByArtistAlbum {

    @SerializedName("#text")
    private String text;
    @SerializedName("fulltrack")
    private String fulltrack;

    public StreamableByArtistAlbum(String text, String fulltrack) {
        this.text = text;
        this.fulltrack = fulltrack;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFulltrack() {
        return fulltrack;
    }

    public void setFulltrack(String fulltrack) {
        this.fulltrack = fulltrack;
    }
}
