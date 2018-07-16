package com.nytsample.android.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NewsMediaModel implements Serializable {
    public String caption = "";

    @SerializedName("media-metadata")
    public List<MediaMetaDataModel> mediaMetadataList = new ArrayList<>();
}
