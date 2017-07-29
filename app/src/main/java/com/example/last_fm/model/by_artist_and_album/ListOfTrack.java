package com.example.last_fm.model.by_artist_and_album;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class ListOfTrack {

    @SerializedName("track")
    private List<TrackByArtistAlbum> listOfTrack;

    public ListOfTrack(List<TrackByArtistAlbum> listOfTrack) {
        this.listOfTrack = listOfTrack;
    }

    public List<TrackByArtistAlbum> getListOfTrack() {
        return listOfTrack;
    }

    public void setListOfTrack(List<TrackByArtistAlbum> listOfTrack) {
        this.listOfTrack = listOfTrack;
    }
}
