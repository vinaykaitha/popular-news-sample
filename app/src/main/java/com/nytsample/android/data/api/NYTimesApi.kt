package com.nytsample.android.data.api

import com.nytsample.android.App
import com.nytsample.android.App.Companion.retrofit
import com.nytsample.android.R
import com.nytsample.android.data.model.NewsFeedResponseModel
import com.nytsample.android.utils.isNetworkConnected
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NYTimesApi {

    companion object {
        private val apiService = retrofit?.create(ApiService::class.java)

        interface NewsFeedCallback {
            fun onSuccess(newsFeedResponseModel: NewsFeedResponseModel)

            fun onFailure(error: String)
        }

        fun getNewsFeed(offset: Int = 0, callback: NewsFeedCallback) {
            if (!App.context.isNetworkConnected()) {
                callback.onFailure(App.context.getString(R.string.api_error_no_network))
                return
            }
            apiService?.getNewsFeed(offset = offset)?.enqueue(object : Callback<NewsFeedResponseModel> {
                override fun onResponse(call: Call<NewsFeedResponseModel>?, response: Response<NewsFeedResponseModel>?) {
                    if (response != null && response.isSuccessful && response.body() != null) {
                        callback.onSuccess(response.body()!!)
                    } else {
                        callback.onFailure(response?.message()
                                ?: App.context.getString(R.string.api_error_default))
                    }
                }

                override fun onFailure(call: Call<NewsFeedResponseModel>?, t: Throwable) {
                    t.printStackTrace()
                    callback.onFailure(t.message
                            ?: App.context.getString(R.string.api_error_default))
                }
            })
        }
    }
}