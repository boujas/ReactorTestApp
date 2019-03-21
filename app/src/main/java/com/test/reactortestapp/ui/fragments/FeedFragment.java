package com.test.reactortestapp.ui.fragments;


import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SearchView;

import com.test.reactortestapp.adapters.FeedRVAdapter;
import com.test.reactortestapp.models.GifObject;
import com.test.reactortestapp.ui.base.BaseFragment;
import com.test.reactortestapp.ui.contracts.FeedContract;
import com.test.reactortestapp.ui.presenters.FeedPresenter;
import com.test.reactortestapp.R;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;


public class FeedFragment extends BaseFragment implements FeedContract.View {

    @BindView(R.id.recycler_view)
    RecyclerView mRecyclerView;
    @BindView(R.id.search_view)
    SearchView mSearchView;

    private FeedContract.Presenter mPresenter;

    private FeedRVAdapter mAdapter;
    private List<GifObject> mTeamList;

    public FeedFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view =  inflater.inflate(R.layout.fragment_feed, container, false);
        ButterKnife.bind(this, view);
        mTeamList = new ArrayList<>();
        mPresenter = new FeedPresenter(this);
        setRecycler();
        mSearchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                mPresenter.searchGifs(s);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                return false;
            }
        });
        return view;
    }

    private void setRecycler(){
        mAdapter = new FeedRVAdapter(mTeamList);
        LinearLayoutManager linearManager = new LinearLayoutManager(getActivity());
        mRecyclerView.setLayoutManager(linearManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    @Override
    public void showList(List<GifObject> m) {
        mTeamList.clear();
        mTeamList.addAll(m);
        mAdapter.notifyDataSetChanged();
    }

    @Override
    public void showError(String error) {
        onError(error);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        mPresenter.onDestroy();
    }

}