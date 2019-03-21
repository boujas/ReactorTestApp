package com.test.reactortestapp;

import com.test.reactortestapp.di.Injector;
import com.test.reactortestapp.ui.fragments.FeedFragment;
import com.test.reactortestapp.ui.presenters.FeedPresenter;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.ArrayList;

import rx.Scheduler;
import rx.android.plugins.RxAndroidPlugins;
import rx.android.plugins.RxAndroidSchedulersHook;
import rx.android.schedulers.AndroidSchedulers;
import rx.plugins.RxJavaHooks;
import rx.schedulers.Schedulers;

import static org.mockito.Mockito.verify;

@RunWith(MockitoJUnitRunner.class)
public class FeedPresenterTest {

    @Mock
    FeedFragment view;

    @Mock
    Injector injector;

    @Mock
    MainApplication context;

    private FeedPresenter presenter;

    @Before
    public void setup() {
        MockitoAnnotations.initMocks(this);
        injector.initializeApplicationComponent(context);
        presenter = new FeedPresenter(view);
        RxAndroidPlugins.getInstance().registerSchedulersHook(new RxAndroidSchedulersHook() {
            @Override
            public Scheduler getMainThreadScheduler() {
                return Schedulers.immediate();
            }
        });
        RxJavaHooks.setOnIOScheduler(scheduler1 -> Schedulers.immediate());
    }

    @Test
    public void testSuccess() {
        presenter.searchGifs("");
        verify(view).showLoading();
        verify(view).showList(new ArrayList<>());
        verify(view).hideLoading();
    }

    @Test
    public void testFailure() {
        presenter.searchGifs(null);
        verify(view).showLoading();
        verify(view).showError("HTTP 401 Unauthorized");
        verify(view).hideLoading();
    }

    @After
    public void before() {
        RxJavaHooks.reset();
        RxAndroidPlugins.getInstance().reset();
        AndroidSchedulers.reset();
        Schedulers.reset();
    }


}
