package com.test.reactortestapp.repositories;


import com.test.reactortestapp.di.Injector;
import com.test.reactortestapp.models.SearchResponse;
import com.test.reactortestapp.network.RestAPI;
import com.test.reactortestapp.ui.contracts.FeedContract;

import javax.inject.Inject;

import rx.Observable;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class FeedRepository implements FeedContract.Repository {

    @Inject
    RestAPI mApi;

    public FeedRepository(){
        Injector.getApplicationComponent().inject(this);
    }

    @Override
    public Observable<SearchResponse> getGifs(String q) {
        return mApi.getGifs(q)
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread());
    }
}
