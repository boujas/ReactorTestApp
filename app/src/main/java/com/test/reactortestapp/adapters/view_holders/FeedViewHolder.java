package com.test.reactortestapp.adapters.view_holders;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.test.reactortestapp.R;
import com.test.reactortestapp.models.GifObject;

import butterknife.BindView;
import butterknife.ButterKnife;

public class FeedViewHolder extends RecyclerView.ViewHolder {

    @BindView(R.id.img_gif)
    ImageView imgGif;
    @BindView(R.id.txt_title)
    TextView txtTitle;
    @BindView(R.id.txt_score_count)
    TextView txtScoreCount;

    public FeedViewHolder(View view) {
        super(view);
        ButterKnife.bind(this, view);
    }

    public void bind(GifObject standing) {
        Glide.with(imgGif.getContext()).load(standing.getGigUrl()).into(imgGif);
        txtTitle.setText(standing.getTitle());
        txtScoreCount.setText(standing.getScore());
    }

}