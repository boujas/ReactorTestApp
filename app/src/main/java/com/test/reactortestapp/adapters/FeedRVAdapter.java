package com.test.reactortestapp.adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.test.reactortestapp.R;
import com.test.reactortestapp.adapters.view_holders.FeedViewHolder;
import com.test.reactortestapp.models.GifObject;

import java.util.List;

public class FeedRVAdapter extends RecyclerView.Adapter<FeedViewHolder> {

    private List<GifObject> mStandingList;

    public FeedRVAdapter(List<GifObject> leagueList) {
        mStandingList = leagueList;
    }

    @Override
    public FeedViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.view_holder_feed, parent, false);
        return new FeedViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final FeedViewHolder holder, final int position) {
        holder.bind(mStandingList.get(position));
    }

    @Override
    public int getItemCount() {
        return mStandingList.size();
    }

}