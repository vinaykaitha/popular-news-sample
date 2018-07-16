package com.nytsample.android.data.model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class NewsFeedResponseModel implements Serializable {
    public String status = "";

    @SerializedName("num_results")
    public int numOfResults = 0;

    public List<NewsFeedItemModel> results = new ArrayList<>();
}
