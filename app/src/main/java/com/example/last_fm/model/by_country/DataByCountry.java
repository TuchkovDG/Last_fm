package com.example.last_fm.model.by_country;

import com.google.gson.annotations.SerializedName;

public class DataByCountry {

    @SerializedName("topartists")
    private TopArtistsByCountry topArtistsByCountry;

    public DataByCountry(TopArtistsByCountry topArtistsByCountry) {
        this.topArtistsByCountry = topArtistsByCountry;
    }

    public TopArtistsByCountry getTopArtistsByCountry() {
        return topArtistsByCountry;
    }

    public void setTopArtistsByCountry(TopArtistsByCountry topArtistsByCountry) {
        this.topArtistsByCountry = topArtistsByCountry;
    }
}
