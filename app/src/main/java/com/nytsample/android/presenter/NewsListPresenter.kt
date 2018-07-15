package com.nytsample.android.presenter

import com.nytsample.android.data.api.NYTimesApi
import com.nytsample.android.data.model.NewsFeedResponseModel
import com.nytsample.android.view.def.NewsListView
import com.nytsample.android.data.api.NYTimesApi.Companion.NewsFeedCallback

class NewsListPresenter(val view: NewsListView) {
    fun fetchNews(offset: Int = 0) {
        view.showLoading()
        NYTimesApi.getNewsFeed(offset, object : NewsFeedCallback {
            override fun onSuccess(newsFeedResponseModel: NewsFeedResponseModel) {
                view.showResults(newsFeedResponseModel)
            }

            override fun onFailure(error: String) {
                view.showError(error)
            }
        })
    }
}