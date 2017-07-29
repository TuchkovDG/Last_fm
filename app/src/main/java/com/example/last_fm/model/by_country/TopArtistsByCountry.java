package com.example.last_fm.model.by_country;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class TopArtistsByCountry {

    @SerializedName("artist")
    private List<ArtistByCountry> artistByCountry;
    @SerializedName("@attr")
    private AttrByCountry attrByCountry;

    public TopArtistsByCountry(List<ArtistByCountry> artistByCountry, AttrByCountry attrByCountry) {
        this.artistByCountry = artistByCountry;
        this.attrByCountry = attrByCountry;
    }

    public List<ArtistByCountry> getArtistByCountry() {
        return artistByCountry;
    }

    public void setArtistByCountry(List<ArtistByCountry> artistByCountry) {
        this.artistByCountry = artistByCountry;
    }

    public AttrByCountry getAttrByCountry() {
        return attrByCountry;
    }

    public void setAttrByCountry(AttrByCountry attrByCountry) {
        this.attrByCountry = attrByCountry;
    }
}
