package com.test.reactortestapp.ui.presenters;

import com.test.reactortestapp.di.Injector;
import com.test.reactortestapp.ui.contracts.FeedContract;

import java.lang.ref.WeakReference;

import javax.inject.Inject;

import rx.Subscription;
import rx.subscriptions.CompositeSubscription;

public class FeedPresenter implements FeedContract.Presenter {

    @Inject
    public FeedContract.Repository mRepository;

    private WeakReference<FeedContract.View> mView;
    private CompositeSubscription compositeSubscription = new CompositeSubscription();

    public FeedPresenter(FeedContract.View view) {
        Injector.getApplicationComponent().inject(this);
        mView = new WeakReference<>(view);
    }

    public void searchGifs(String query) {
        mView.get().showLoading();
        Subscription subscription = mRepository.getGifs(query)
                .subscribe(
                        searchResponse -> {
                            mView.get().hideLoading();
                            mView.get().showList(searchResponse.getData());
                        },
                        throwable -> {
                            mView.get().hideLoading();
                            mView.get().showError(throwable.getMessage());
                        }
                );
        compositeSubscription.add(subscription);
    }

    public void onDestroy() {
        compositeSubscription.clear();
    }

}
