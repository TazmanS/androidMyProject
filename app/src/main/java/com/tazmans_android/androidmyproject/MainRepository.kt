package com.tazmans_android.androidmyproject

import com.tazmans_android.androidmyproject.api.NetworkService
import com.tazmans_android.androidmyproject.api.request.SignUpRequest

class MainRepository {
    private var authService = NetworkService.authService

    suspend fun signUp(signUpRequest: SignUpRequest) {
        authService.signUp(signUpRequest)
    }
}