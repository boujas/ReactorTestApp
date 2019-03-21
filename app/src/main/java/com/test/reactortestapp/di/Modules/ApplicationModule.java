package com.test.reactortestapp.di.Modules;

import android.app.Application;

import com.test.reactortestapp.MainApplication;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class ApplicationModule {

    private final MainApplication application;

    public ApplicationModule(MainApplication application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application application() {
        return application;
    }

}