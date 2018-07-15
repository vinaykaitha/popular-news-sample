package com.nytsample.android.utils

import android.widget.ImageView
import com.bumptech.glide.Glide
import android.app.Activity

fun ImageView.load(url: String?) {
    if (!isValidContextForGlide()) return
    Glide.with(context)
            .load(url)
            .into(this)

}

fun ImageView.isValidContextForGlide(): Boolean {
    if (context == null) {
        return false
    }
    if (context is Activity) {
        val activity = context as Activity
        if (activity.isDestroyed || activity.isFinishing) {
            return false
        }
    }
    return true
}