package com.tazmans_android.androidmyproject.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkBase {
    var retrofitBuilder =
        Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(
            GsonConverterFactory.create()
        ).build()
}