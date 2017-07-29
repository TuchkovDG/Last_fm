package com.example.last_fm.model.by_artist;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopAlbumsByArtist {

    @SerializedName("album")
    private List<AlbumByArtist> albumByArtist;
    @SerializedName("@attr")
    private AttrByArtist attrByArtist;

    public TopAlbumsByArtist(List<AlbumByArtist> albumByArtist, AttrByArtist attrByArtist) {
        this.albumByArtist = albumByArtist;
        this.attrByArtist = attrByArtist;
    }

    public List<AlbumByArtist> getAlbumByArtist() {
        return albumByArtist;
    }

    public void setAlbumByArtist(List<AlbumByArtist> albumByArtist) {
        this.albumByArtist = albumByArtist;
    }

    public AttrByArtist getAttrByArtist() {
        return attrByArtist;
    }

    public void setAttrByArtist(AttrByArtist attrByArtist) {
        this.attrByArtist = attrByArtist;
    }
}
