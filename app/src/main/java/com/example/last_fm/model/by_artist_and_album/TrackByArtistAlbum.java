package com.example.last_fm.model.by_artist_and_album;

import com.example.last_fm.model.by_artist.ArtistByArtist;
import com.google.gson.annotations.SerializedName;

class TrackByArtistAlbum {

    @SerializedName("name")
    private String name;
    @SerializedName("url")
    private String url;
    @SerializedName("duration")
    private String duration;
    @SerializedName("@attr")
    private AttrByArtistAlbum attr;
    @SerializedName("streamable")
    private StreamableByArtistAlbum streamable;
    @SerializedName("artist")
    private ArtistByArtist artist;

    public TrackByArtistAlbum(String name, String url, String duration, AttrByArtistAlbum attr,
                              StreamableByArtistAlbum streamable, ArtistByArtist artist) {
        this.name = name;
        this.url = url;
        this.duration = duration;
        this.attr = attr;
        this.streamable = streamable;
        this.artist = artist;
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

    public String getDuration() {
        return duration;
    }

    public void setDuration(String duration) {
        this.duration = duration;
    }

    public AttrByArtistAlbum getAttr() {
        return attr;
    }

    public void setAttr(AttrByArtistAlbum attr) {
        this.attr = attr;
    }

    public StreamableByArtistAlbum getStreamable() {
        return streamable;
    }

    public void setStreamable(StreamableByArtistAlbum streamable) {
        this.streamable = streamable;
    }

    public ArtistByArtist getArtist() {
        return artist;
    }

    public void setArtist(ArtistByArtist artist) {
        this.artist = artist;
    }
}
