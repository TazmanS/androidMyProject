package com.tazmans_android.androidmyproject.api

object NetworkService {
    private var builder = NetworkBase.retrofitBuilder

    var authService = builder.create(AuthAPI::class.java)
}