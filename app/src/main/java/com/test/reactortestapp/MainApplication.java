package com.test.reactortestapp;

import android.app.Application;

import com.test.reactortestapp.di.Injector;

public class MainApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        initDagger();
    }

    protected void initDagger() {
        Injector.initializeApplicationComponent(this);
        Injector.getApplicationComponent().inject(this);
    }

}
