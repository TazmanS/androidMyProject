package com.tazmans_android.androidmyproject.api

import com.tazmans_android.androidmyproject.api.service.AuthAPIService

object APIServices {
    private var builder = NetworkBase().retrofitBuilder

    var authService = builder.create(AuthAPIService::class.java)
}