package com.nytsample.android.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NewsFeedItemModel implements Serializable {
    public long id = 0;
    public String url = "";
    public String title = "";
    @SerializedName("byline")
    public String byLine = "";
    @SerializedName("published_date")
    public String publishedDate = "";
    public List<NewsMediaModel> media = new ArrayList<>();

    public String getPhotoUrl() {
        if (media != null && media.size() > 0 && media.get(0).mediaMetadataList != null && media.get(0).mediaMetadataList.size() > 0) {
            return media.get(0).mediaMetadataList.get(0).url;
        }
        return null;
    }
}
