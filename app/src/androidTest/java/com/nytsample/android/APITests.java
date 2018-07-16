package com.nytsample.android;

import com.nytsample.android.data.api.NYTimesAPI;
import com.nytsample.android.data.model.NewsFeedResponseModel;

import org.junit.Test;

import static org.junit.Assert.assertTrue;

public class APITests {
    @Test
    public void test_getNewsFeedSuccess() {
        NYTimesAPI.getNewsFeed(0, new NYTimesAPI.NewsFeedCallback() {
            @Override
            public void onSuccess(NewsFeedResponseModel newsFeedResponseModel) {
                assertTrue(newsFeedResponseModel != null);
                assertTrue(newsFeedResponseModel.numOfResults > 0);
            }

            @Override
            public void onFailure(String error) {

            }
        });
    }

    @Test
    public void test_getNewsFeedFail() {
        NYTimesAPI.getNewsFeed(5, new NYTimesAPI.NewsFeedCallback() {
            @Override
            public void onSuccess(NewsFeedResponseModel newsFeedResponseModel) {

            }

            @Override
            public void onFailure(String error) {
                assertTrue(!error.isEmpty());
            }
        });
    }
}
