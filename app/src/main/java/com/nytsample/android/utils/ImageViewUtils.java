package com.nytsample.android.utils;

import com.bumptech.glide.Glide;

import android.app.Activity;
import android.widget.ImageView;

public class ImageViewUtils {
    public static void loadImage(ImageView imageView, String url) {
        if (!isValidContextForGlide(imageView)) return;
        Glide.with(imageView.getContext())
                .load(url)
                .into(imageView);
    }

    public static boolean isValidContextForGlide(ImageView imageView) {
        if (imageView.getContext() == null) {
            return false;
        }
        if (imageView.getContext() instanceof Activity) {
            Activity activity = (Activity) imageView.getContext();
            return !activity.isDestroyed() && !activity.isFinishing();
        }
        return true;
    }
}
