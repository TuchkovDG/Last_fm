package com.example.last_fm.model.by_artist_and_album;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class ListOfTag {

    @SerializedName("tag")
    private List<TagByArtistAlbum> listOfTag;

    public ListOfTag(List<TagByArtistAlbum> listOfTag) {
        this.listOfTag = listOfTag;
    }

    public List<TagByArtistAlbum> getListOfTag() {
        return listOfTag;
    }

    public void setListOfTag(List<TagByArtistAlbum> listOfTag) {
        this.listOfTag = listOfTag;
    }
}
