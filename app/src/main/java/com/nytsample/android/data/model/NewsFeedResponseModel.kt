package com.nytsample.android.data.model

import com.google.gson.annotations.SerializedName

class NewsFeedResponseModel {
    var status: String = ""

    @SerializedName("num_results")
    var numOfResults: Int = 0

    var results: List<NewsFeedItemModel> = emptyList()
}