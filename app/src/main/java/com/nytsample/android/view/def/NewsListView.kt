package com.nytsample.android.view.def

import com.nytsample.android.data.model.NewsFeedResponseModel

interface NewsListView {

    fun showLoading()

    fun showResults(newsResponse: NewsFeedResponseModel)

    fun showError(error: String)
}