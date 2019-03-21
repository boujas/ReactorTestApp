package com.test.reactortestapp.models;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class SearchResponse {

    @SerializedName("data")
    private List<GifObject> data;

    @SerializedName("pagination")
    private Pagination pagination;

    @SerializedName("meta")
    private Meta meta;

    public List<GifObject> getData() {
        return data;
    }

    //TODO add pagination
    public Pagination getPagination() {
        return pagination;
    }

    //TODO add meta
    public Meta getMeta() {
        return meta;
    }
}
