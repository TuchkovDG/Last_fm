package com.example.last_fm.model;

import com.google.gson.annotations.SerializedName;

public class Image {

    @SerializedName("#text")
    private String text;
    @SerializedName("size")
    private String size;

    public Image(String text, String size) {
        this.text = text;
        this.size = size;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}
