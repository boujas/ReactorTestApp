package com.test.reactortestapp.di.Modules;

import com.test.reactortestapp.repositories.FeedRepository;
import com.test.reactortestapp.ui.contracts.FeedContract;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    FeedContract.Repository provideFeedRepository(){
        return new FeedRepository();
    }

}
