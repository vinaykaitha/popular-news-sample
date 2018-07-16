package com.nytsample.android.presenter;

import com.nytsample.android.data.api.NYTimesAPI;
import com.nytsample.android.data.model.NewsFeedResponseModel;
import com.nytsample.android.view.def.NewsListView;

import org.jetbrains.annotations.NotNull;

public class NewsListPresenter {
    private final NewsListView view;

    public NewsListPresenter(NewsListView view) {
        this.view = view;
    }

    public void fetchNews(int offset) {
        view.showLoading();

        NYTimesAPI.getNewsFeed(offset, new NYTimesAPI.NewsFeedCallback() {
            @Override
            public void onSuccess(@NotNull NewsFeedResponseModel newsFeedResponseModel) {
                view.showResults(newsFeedResponseModel);
            }

            @Override
            public void onFailure(@NotNull String error) {
                view.showError(error);
            }
        });
    }
}
