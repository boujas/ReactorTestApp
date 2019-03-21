package com.test.reactortestapp.di;

import com.test.reactortestapp.di.Modules.RepositoryModule;
import com.test.reactortestapp.repositories.FeedRepository;
import com.test.reactortestapp.MainApplication;
import com.test.reactortestapp.di.Modules.ApplicationModule;
import com.test.reactortestapp.di.Modules.NetModule;
import com.test.reactortestapp.ui.presenters.FeedPresenter;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules ={ApplicationModule.class, NetModule.class, RepositoryModule.class})
public interface ApplicationComponent {

    void inject(FeedRepository feedRepository);

    void inject(MainApplication application);

    void inject(FeedPresenter feedPresenter);

}