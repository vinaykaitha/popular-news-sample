package com.nytsample.android.data.api

import com.nytsample.android.BuildConfig
import com.nytsample.android.data.model.NewsFeedResponseModel
import retrofit2.Call
import retrofit2.http.*

interface ApiService {
    @GET(BuildConfig.POPULAR_NEWS_PATH)
    fun getNewsFeed(@Query("api-key") apiKey: String = BuildConfig.API_KEY,
                    @Query("offset") offset: Int = 0): Call<NewsFeedResponseModel>

}