package com.tazmans_android.androidmyproject.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkBase {
    var retrofitBuilder =
        Retrofit.Builder().baseUrl("http://192.168.0.101:3000/").addConverterFactory(
            GsonConverterFactory.create()
        ).build()
}