package com.nytsample.android.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class NewsFeedItemModel : Serializable {
    var id: Long = 0L
    var url: String = ""
    var title: String = ""
    @SerializedName("byline")
    var byLine: String = ""
    @SerializedName("published_date")
    var publishedDate: String = ""
    var media: List<NewsMediaModel>? = emptyList()

    fun getPhotoUrl(): String? {
        return media?.firstOrNull()?.mediaMetadataList?.firstOrNull()?.url
    }
}