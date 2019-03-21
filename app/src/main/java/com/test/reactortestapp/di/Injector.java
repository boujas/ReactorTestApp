package com.test.reactortestapp.di;

import com.test.reactortestapp.MainApplication;
import com.test.reactortestapp.di.Modules.ApplicationModule;
import com.test.reactortestapp.di.Modules.NetModule;
import com.test.reactortestapp.di.Modules.RepositoryModule;

public class Injector {

    private static ApplicationComponent applicationComponent;

    private Injector() {
    }

    public static void initializeApplicationComponent(MainApplication application) {
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(application))
                .netModule(new NetModule())
                .repositoryModule(new RepositoryModule())
                .build();
    }

    public static ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }

}
