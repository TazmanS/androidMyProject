package com.tazmans_android.androidmyproject

import com.tazmans_android.androidmyproject.api.BaseRepo
import com.tazmans_android.androidmyproject.api.NetworkResult
import com.tazmans_android.androidmyproject.api.NetworkService
import com.tazmans_android.androidmyproject.api.request.SignUpRequest
import com.tazmans_android.androidmyproject.api.response.SignUpResponse

class MainRepository : BaseRepo() {
    private var authService = NetworkService.authService

    suspend fun signUp(signUpRequest: SignUpRequest): NetworkResult<SignUpResponse> {
//        return authService.signUp(signUpRequest)
        return safeApiCall { authService.signUp(signUpRequest) }
    }


}