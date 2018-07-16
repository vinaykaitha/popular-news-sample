package com.nytsample.android

import android.app.Application
import android.content.Context
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class App : Application() {

    companion object {
        var instance: App? = null
        val context: Context get() = instance!!.applicationContext
        var retrofit: Retrofit? = null
    }

    override fun onCreate() {
        super.onCreate()

        instance = this

        retrofit = Retrofit.Builder()
                .baseUrl(BuildConfig.BASE_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
    }
}
