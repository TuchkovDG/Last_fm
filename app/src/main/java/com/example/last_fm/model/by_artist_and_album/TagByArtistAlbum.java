package com.example.last_fm.model.by_artist_and_album;

import com.google.gson.annotations.SerializedName;

class TagByArtistAlbum {

    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;

    public TagByArtistAlbum(String name, String url) {
        this.name = name;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
