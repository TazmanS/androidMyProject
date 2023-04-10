package com.tazmans_android.androidmyproject

import androidx.lifecycle.LiveData
import com.tazmans_android.androidmyproject.api.APIServices
import com.tazmans_android.androidmyproject.api.BaseRepo
import com.tazmans_android.androidmyproject.api.Resource
import com.tazmans_android.androidmyproject.api.request.SignUpRequest
import com.tazmans_android.androidmyproject.api.response.SignUpResponse
import com.tazmans_android.androidmyproject.store.TokenDao
import com.tazmans_android.androidmyproject.store.TokenEntity

class MainRepository(private val tokenDao: TokenDao) : BaseRepo() {
    private var authService = APIServices.authService
    val token: LiveData<List<String>> = tokenDao.getToken()

    suspend fun signUp(signUpRequest: SignUpRequest): Resource<SignUpResponse> {
        return safeApiCall { authService.signUp(signUpRequest) }
    }

    suspend fun setToken(token: String) {
        tokenDao.setToken(TokenEntity(accessToken = token))
    }

}