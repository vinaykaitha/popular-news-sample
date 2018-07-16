package com.nytsample.android

import com.nytsample.android.data.api.NYTimesApi
import com.nytsample.android.data.model.NewsFeedResponseModel
import org.junit.Assert
import org.junit.Test

class APITests {
    @Test
    fun test_getNewsFeedSuccess() {
        NYTimesApi.getNewsFeed(callback = object : NYTimesApi.Companion.NewsFeedCallback {
            override fun onSuccess(newsFeedResponseModel: NewsFeedResponseModel) {
                Assert.assertTrue(newsFeedResponseModel != null)
                Assert.assertTrue(newsFeedResponseModel.numOfResults > 0)
            }

            override fun onFailure(error: String) {
            }
        })
    }

    @Test
    fun test_getNewsFeedFail() {
        NYTimesApi.getNewsFeed(5, object : NYTimesApi.Companion.NewsFeedCallback {
            override fun onSuccess(newsFeedResponseModel: NewsFeedResponseModel) {
            }

            override fun onFailure(error: String) {
                Assert.assertTrue(error.isNotEmpty())
            }
        })
    }
}