package com.example.last_fm.model.by_artist_and_album;

import com.example.last_fm.model.Image;
import com.google.gson.annotations.SerializedName;

public class AlbumByArtistAlbum {

    @SerializedName("name")
    private String name;
    @SerializedName("artist")
    private String artist;
    @SerializedName("mbid")
    private String mbid;
    @SerializedName("url")
    private String url;
    @SerializedName("image")
    private Image image;
    @SerializedName("listeners")
    private String listeners;
    @SerializedName("playcount")
    private String playcount;
    @SerializedName("tracks")
    private ListOfTrack listOfTrack;
    @SerializedName("tags")
    private ListOfTag listOfTag;
    @SerializedName("wiki")
    private WikiByArtistAlbum wikiByArtistAlbum;

    public AlbumByArtistAlbum(String name, String artist, String mbid, String url, Image image,
                              String listeners, String playcount, ListOfTrack listOfTrack, ListOfTag listOfTag, WikiByArtistAlbum wikiByArtistAlbum) {
        this.name = name;
        this.artist = artist;
        this.mbid = mbid;
        this.url = url;
        this.image = image;
        this.listeners = listeners;
        this.playcount = playcount;
        this.listOfTrack = listOfTrack;
        this.listOfTag = listOfTag;
        this.wikiByArtistAlbum = wikiByArtistAlbum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;
    }

    public String getListeners() {
        return listeners;
    }

    public void setListeners(String listeners) {
        this.listeners = listeners;
    }

    public String getPlaycount() {
        return playcount;
    }

    public void setPlaycount(String playcount) {
        this.playcount = playcount;
    }

    public ListOfTrack getListOfTrack() {
        return listOfTrack;
    }

    public void setListOfTrack(ListOfTrack listOfTrack) {
        this.listOfTrack = listOfTrack;
    }

    public ListOfTag getListOfTag() {
        return listOfTag;
    }

    public void setListOfTag(ListOfTag listOfTag) {
        this.listOfTag = listOfTag;
    }

    public WikiByArtistAlbum getWikiByArtistAlbum() {
        return wikiByArtistAlbum;
    }

    public void setWikiByArtistAlbum(WikiByArtistAlbum wikiByArtistAlbum) {
        this.wikiByArtistAlbum = wikiByArtistAlbum;
    }
}
