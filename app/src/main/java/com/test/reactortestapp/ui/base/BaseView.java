package com.test.reactortestapp.ui.base;

import android.support.annotation.StringRes;

public interface BaseView {

    void showLoading();

    void hideLoading();

    void onError(@StringRes int resId);

    void onError(String message);

    String getStringFromRes(int res);

    void hideKeyboard();

}