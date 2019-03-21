package com.test.reactortestapp.ui.contracts;

import com.test.reactortestapp.models.GifObject;
import com.test.reactortestapp.models.SearchResponse;

import java.util.List;

import rx.Observable;

public class FeedContract {

    public interface View {

        void showList(List<GifObject> m);

        void showError(String error);

        void showLoading();

        void hideLoading();

    }

    public interface Presenter {

        void searchGifs(String query);

        void onDestroy();

    }

    public interface Repository {

        Observable<SearchResponse> getGifs(String q);

    }

}
