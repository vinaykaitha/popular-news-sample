package com.nytsample.android.data.api;

import com.nytsample.android.BuildConfig;
import com.nytsample.android.data.model.NewsFeedResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface APIService {
    @GET(BuildConfig.POPULAR_NEWS_PATH)
    Call<NewsFeedResponseModel> getNewsFeed(@Query("api-key") String apiKey,
                                            @Query("offset") int offset);
}