package com.test.reactortestapp.network;

import com.test.reactortestapp.models.SearchResponse;

import okhttp3.ResponseBody;
import retrofit2.http.GET;
import retrofit2.http.Query;
import rx.Observable;

public interface RestAPI {

    @GET("/v1/gifs/search")
    Observable<SearchResponse> getGifs(@Query("q") String q);

}
