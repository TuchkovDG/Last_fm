package com.example.last_fm.model.by_artist_and_album;

import com.google.gson.annotations.SerializedName;

class WikiByArtistAlbum {

    @SerializedName("published")
    private String published;
    @SerializedName("summary")
    private String summary;
    @SerializedName("content")
    private String content;

    public WikiByArtistAlbum(String published, String summary, String content) {
        this.published = published;
        this.summary = summary;
        this.content = content;
    }

    public String getPublished() {
        return published;
    }

    public void setPublished(String published) {
        this.published = published;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
