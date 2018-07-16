package com.nytsample.android.view;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.nytsample.android.R;
import com.nytsample.android.data.model.NewsFeedItemModel;
import com.nytsample.android.utils.ImageViewUtils;
import com.nytsample.android.view.def.NewsDetailsView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailsFragment extends Fragment implements NewsDetailsView {

    private static final String ARG_NEWS_FEED_ITEM = "news_feed_item";

    @BindView(R.id.imageViewPhoto)
    ImageView imageViewPhoto;
    @BindView(R.id.textViewTitle)
    TextView textViewTitle;
    @BindView(R.id.textViewByLine)
    TextView textViewByLine;
    @BindView(R.id.textViewDate)
    TextView textViewDate;

    public static NewsDetailsFragment newInstance(NewsFeedItemModel newsFeedItemModel) {
        NewsDetailsFragment fragment = new NewsDetailsFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable(ARG_NEWS_FEED_ITEM, newsFeedItemModel);
        fragment.setArguments(bundle);
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_details, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        NewsFeedItemModel newsFeedItemModel = getNewsFeedItemArg();
        if (newsFeedItemModel != null) {
            showDetails(newsFeedItemModel);
        } else {
            throw new IllegalStateException("Use NewsDetailsFragment.newInstance(NewsFeedItemModel newsFeedItemModel)");
        }
    }

    @Override
    public void showDetails(NewsFeedItemModel newsFeedItem) {
        ImageViewUtils.loadImage(imageViewPhoto, newsFeedItem.getPhotoUrl());
        textViewTitle.setText(newsFeedItem.title);
        textViewByLine.setText(newsFeedItem.byLine);
        textViewDate.setText(newsFeedItem.publishedDate);
    }

    private NewsFeedItemModel getNewsFeedItemArg() {
        if (getArguments() != null && getArguments().containsKey(ARG_NEWS_FEED_ITEM)) {
            return (NewsFeedItemModel) getArguments().getSerializable(ARG_NEWS_FEED_ITEM);
        }
        return null;
    }
}
