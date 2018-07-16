package com.nytsample.android.data.api;

import android.support.annotation.NonNull;

import com.nytsample.android.App;
import com.nytsample.android.BuildConfig;
import com.nytsample.android.R;
import com.nytsample.android.data.model.NewsFeedResponseModel;
import com.nytsample.android.utils.ContextUtils;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class NYTimesAPI {

    public interface NewsFeedCallback {
        void onSuccess(NewsFeedResponseModel newsFeedResponseModel);

        void onFailure(String error);
    }

    public static void getNewsFeed(int offset, final NewsFeedCallback callback) {
        if (!ContextUtils.isNetworkConnected()) {
            callback.onFailure(App.getInstance().getString(R.string.api_error_no_network));
        } else {
            Retrofit retrofit = App.getRetrofit();
            APIService apiService = retrofit.create(APIService.class);

            Call<NewsFeedResponseModel> call = apiService.getNewsFeed(BuildConfig.API_KEY, offset);
            call.enqueue(new Callback<NewsFeedResponseModel>() {
                @Override
                public void onResponse(@NonNull Call<NewsFeedResponseModel> call, @NonNull Response<NewsFeedResponseModel> response) {
                    if (response.isSuccessful() && response.body() != null) {
                        callback.onSuccess(response.body());
                    } else {
                        callback.onFailure(response.message());
                    }
                }

                @Override
                public void onFailure(@NonNull Call<NewsFeedResponseModel> call, @NonNull Throwable t) {
                    t.printStackTrace();
                    callback.onFailure(t.getMessage());
                }
            });
        }
    }
}
