package com.test.reactortestapp.network;

import com.test.reactortestapp.utils.Const;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class HeaderInterceptor implements Interceptor {

    private static HeaderInterceptor sInterceptor;

    public static HeaderInterceptor get() {
        if (sInterceptor == null) {
            sInterceptor = new HeaderInterceptor();
        }
        return sInterceptor;
    }

    private HeaderInterceptor() {
        // Intentionally blank
    }

    @Override
    public Response intercept(Chain chain) throws IOException {
        Request original = chain.request();
        StringBuilder builder = new StringBuilder()
                .append(original.url().toString())
                .append("&api_key=")
                .append(Const.API_KEY);
        Request.Builder requestBuilder = original.newBuilder().url(builder.toString());
        Request request = requestBuilder.build();
        return chain.proceed(request);
    }

}