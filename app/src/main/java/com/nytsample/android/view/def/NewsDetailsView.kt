package com.nytsample.android.view.def

import com.nytsample.android.data.model.NewsFeedItemModel

interface NewsDetailsView {
    fun showDetails(newsFeedItem: NewsFeedItemModel)
}