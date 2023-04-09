package com.tazmans_android.androidmyproject.api

import com.tazmans_android.androidmyproject.api.request.SignUpRequest
import com.tazmans_android.androidmyproject.api.response.SignUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPI {
//    @GET("posts/1")
//    suspend fun getTest(): Response<TestItem>

    @POST("/users")
    suspend fun signUp(@Body signUpRequest: SignUpRequest): Response<SignUpResponse>
}