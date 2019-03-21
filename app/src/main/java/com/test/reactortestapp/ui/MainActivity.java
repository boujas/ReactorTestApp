package com.test.reactortestapp.ui;

import android.os.Bundle;

import com.test.reactortestapp.R;
import com.test.reactortestapp.ui.base.BaseActivity;
import com.test.reactortestapp.ui.fragments.FeedFragment;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getFragmentManager().beginTransaction()
                .replace(R.id.container, new FeedFragment())
                .commit();
    }

}
