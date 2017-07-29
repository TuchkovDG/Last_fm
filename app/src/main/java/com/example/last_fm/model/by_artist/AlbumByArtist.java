package com.example.last_fm.model.by_artist;

import com.example.last_fm.model.Image;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class AlbumByArtist {

    @SerializedName("name")
    private String name;
    @SerializedName("playcount")
    private int playcount;
    @SerializedName("mbid")
    private String mbid;
    @SerializedName("url")
    private String url;
    @SerializedName("artist")
    private ArtistByArtist artist;
    @SerializedName("image")
    private List<Image> image;

    public AlbumByArtist(String name, int playcount, String mbid, String url, ArtistByArtist artist, List<Image> image) {
        this.name = name;
        this.playcount = playcount;
        this.mbid = mbid;
        this.url = url;
        this.artist = artist;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPlaycount() {
        return playcount;
    }

    public void setPlaycount(int playcount) {
        this.playcount = playcount;
    }

    public String getMbid() {
        return mbid;
    }

    public void setMbid(String mbid) {
        this.mbid = mbid;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public ArtistByArtist getArtist() {
        return artist;
    }

    public void setArtist(ArtistByArtist artist) {
        this.artist = artist;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }
}
