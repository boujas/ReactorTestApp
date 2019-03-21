package com.test.reactortestapp.models;

import com.google.gson.annotations.SerializedName;
import com.google.gson.internal.LinkedTreeMap;

public class GifObject {

    @SerializedName("type")
    private String type;

    @SerializedName("id")
    private String id;

    @SerializedName("images")
    private LinkedTreeMap<Object, Object> images;

    @SerializedName("title")
    private String title;

    @SerializedName("_score")
    private String score;

    public GifObject() {
    }

    public GifObject(String type, String id, String title, String score) {
        this.type = type;
        this.id = id;

        this.title = title;
        this.score = score;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getGigUrl() {
        // Gif by original URL is too large for glide, that's why I should use this strange part of response with small gif
        LinkedTreeMap<Object, Object> previewGif = (LinkedTreeMap<Object, Object>) images.get("preview_gif");
        String url = previewGif != null ? (String) previewGif.get("url") : "";
        return url != null ? url : "";
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "GifObject{" +
                "type='" + type + '\'' +
                ", id='" + id + '\'' +
                ", title='" + title + '\'' +
                ", score='" + score + '\'' +
                '}';
    }

}
