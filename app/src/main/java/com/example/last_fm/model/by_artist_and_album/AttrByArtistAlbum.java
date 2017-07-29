package com.example.last_fm.model.by_artist_and_album;

import com.google.gson.annotations.SerializedName;

class AttrByArtistAlbum {

    @SerializedName("rank")
    private String rank;

    public AttrByArtistAlbum(String rank) {
        this.rank = rank;
    }

    public String getRank() {
        return rank;
    }

    public void setRank(String rank) {
        this.rank = rank;
    }
}
