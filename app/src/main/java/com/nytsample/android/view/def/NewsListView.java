package com.nytsample.android.view.def;

import com.nytsample.android.data.model.NewsFeedResponseModel;

public interface NewsListView {
    void showLoading();

    void showResults(NewsFeedResponseModel newsResponse);

    void showError(String error);
}