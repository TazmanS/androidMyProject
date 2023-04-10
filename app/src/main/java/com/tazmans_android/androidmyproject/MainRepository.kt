package com.tazmans_android.androidmyproject

import com.tazmans_android.androidmyproject.api.APIServices
import com.tazmans_android.androidmyproject.api.BaseRepo
import com.tazmans_android.androidmyproject.api.Resource
import com.tazmans_android.androidmyproject.api.request.SignUpRequest
import com.tazmans_android.androidmyproject.api.response.SignUpResponse

class MainRepository : BaseRepo() {
    private var authService = APIServices.authService

    suspend fun signUp(signUpRequest: SignUpRequest): Resource<SignUpResponse> {
        return safeApiCall { authService.signUp(signUpRequest) }
    }


}