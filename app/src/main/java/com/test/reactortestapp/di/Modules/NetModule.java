package com.test.reactortestapp.di.Modules;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.test.reactortestapp.utils.Const;
import com.test.reactortestapp.network.HeaderInterceptor;
import com.test.reactortestapp.network.RestAPI;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    @Provides
    @Singleton
    HeaderInterceptor provideCookieInterceptor() {
        return HeaderInterceptor.get();
    }

    @Provides
    @Singleton
    OkHttpClient providesOkHttp(HeaderInterceptor headerInterceptor) {
        return new OkHttpClient.Builder()
                .connectTimeout(20, TimeUnit.SECONDS)
                .writeTimeout(20, TimeUnit.SECONDS)
                .readTimeout(40, TimeUnit.SECONDS)
                .retryOnConnectionFailure(true)
                .addInterceptor(headerInterceptor)
                .build();
    }

    @Provides
    @Singleton
    Gson provideGson() {
        return new GsonBuilder()
                .setDateFormat("yyyy-MM-dd'T'HH:mm:ss")
                .create();
    }

    @Provides
    @Singleton
    Retrofit providesRetrofit(OkHttpClient client, Gson gson) {
        return new Retrofit.Builder()
                .baseUrl(Const.BASE_URL)
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(client)
                .build();
    }

    @Provides
    @Singleton
    RestAPI providesService(Retrofit retrofit) {
        return retrofit.create(RestAPI.class);
    }

}