package com.tazmans_android.androidmyproject.api.service

import com.tazmans_android.androidmyproject.api.request.SignInRequest
import com.tazmans_android.androidmyproject.api.request.SignUpRequest
import com.tazmans_android.androidmyproject.api.response.ProfileResponse
import com.tazmans_android.androidmyproject.api.response.SignInResponse
import com.tazmans_android.androidmyproject.api.response.SignUpResponse
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST

interface AuthAPIService {
    @POST("/users")
    suspend fun signUp(@Body signUpRequest: SignUpRequest): Response<SignUpResponse>

    @POST("auth/login")
    suspend fun signIn(@Body signInRequest: SignInRequest): Response<SignInResponse>

    @GET("/users/profile")
    suspend fun getProfile(): Response<ProfileResponse>
}