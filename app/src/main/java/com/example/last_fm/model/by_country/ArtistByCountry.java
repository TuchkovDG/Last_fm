package com.example.last_fm.model.by_country;

import com.example.last_fm.model.Image;
import com.google.gson.annotations.SerializedName;

import java.util.Comparator;
import java.util.List;

public class ArtistByCountry {

    @SerializedName("name")
    private String name;
    @SerializedName("listeners")
    private String listeners;
    @SerializedName("mbid")
    private String mbid;
    @SerializedName("url")
    private String url;
    @SerializedName("streamable")
    private String streamable;
    @SerializedName("image")
    private List<Image> image;

    public ArtistByCountry(String name, String listeners, String mbid, String url,
                           String streamable, List<Image> image) {
        this.name = name;
        this.listeners = listeners;
        this.mbid = mbid;
        this.url = url;
        this.streamable = streamable;
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
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

    public String getStreamable() {
        return streamable;
    }

    public void setStreamable(String streamable) {
        this.streamable = streamable;
    }

    public List<Image> getImage() {
        return image;
    }

    public void setImage(List<Image> image) {
        this.image = image;
    }

    public static class SortComparator implements Comparator<ArtistByCountry> {
        public int compare(ArtistByCountry p1, ArtistByCountry p2) {
            return p1.getName().compareTo(p2.getName());
        }
    }
}
