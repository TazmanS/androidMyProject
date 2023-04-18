package com.tazmans_android.androidmyproject.api

import com.tazmans_android.androidmyproject.store.TokenDao
import okhttp3.Interceptor
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit

class NetworkBase(tokenDao: TokenDao) {

    private var token: String? = null

    init {
        tokenDao.getToken().observeForever {
            token = it
        }
    }

    private val authInterceptor = Interceptor { chain ->
        var req = chain.request()
        token?.let {
            req = req.newBuilder()
                .header("Authorization", "Bearer $it")
                .build()
        }
        chain.proceed(req)
    }

    val okHttpBuilder = OkHttpClient.Builder()
        .readTimeout(5, TimeUnit.SECONDS)
        .connectTimeout(2, TimeUnit.SECONDS)

    var retrofitBuilder =
        Retrofit.Builder().baseUrl("http://192.168.0.101:3000/").addConverterFactory(
            GsonConverterFactory.create()
        ).client(okHttpBuilder.addInterceptor(authInterceptor).build()).build()
}