package com.nytsample.android.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.widget.Toast;

import com.nytsample.android.App;

public class ContextUtils {
    public static void showToast(String text) {
        Toast.makeText(App.getInstance(), text, Toast.LENGTH_SHORT).show();
    }

    public static boolean isNetworkConnected() {
        ConnectivityManager cm = (ConnectivityManager) App.getInstance().getSystemService(Context.CONNECTIVITY_SERVICE);
        return cm != null && cm.getActiveNetworkInfo() != null && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}