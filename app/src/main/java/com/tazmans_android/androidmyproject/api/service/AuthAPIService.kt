package com.tazmans_android.androidmyproject.api.service

import com.tazmans_android.androidmyproject.api.request.SignUpRequest
import com.tazmans_android.androidmyproject.api.response.SignUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthAPIService {
//    @GET("posts/1")
//    suspend fun getTest(): Response<TestItem>

    @POST("/users")
    suspend fun signUp(@Body signUpRequest: SignUpRequest): Response<SignUpResponse>
}