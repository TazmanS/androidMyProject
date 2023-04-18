package com.tazmans_android.androidmyproject.api

import com.tazmans_android.androidmyproject.api.service.AuthAPIService
import com.tazmans_android.androidmyproject.store.TokenDao

class APIServices(tokenDao: TokenDao) {
    private var builder = NetworkBase(tokenDao).retrofitBuilder

    var authService = builder.create(AuthAPIService::class.java)
}