package com.nytsample.android.data.model

import com.google.gson.annotations.SerializedName
import java.io.Serializable

class NewsMediaModel : Serializable{

    var caption: String = ""

    @SerializedName("media-metadata")
    var mediaMetadataList: List<MediaMetaDataModel>? = emptyList()
}