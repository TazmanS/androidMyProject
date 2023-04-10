package com.tazmans_android.androidmyproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.tazmans_android.androidmyproject.api.Resource
import com.tazmans_android.androidmyproject.api.request.SignUpRequest
import com.tazmans_android.androidmyproject.api.response.SignUpResponse
import com.tazmans_android.androidmyproject.store.MainDataBase
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private var tokenDao = MainDataBase.getDataBase(application).getTokenDao()

    private val repository: MainRepository = MainRepository(tokenDao)
    val token = repository.token

    suspend fun signUp(signUpRequest: SignUpRequest): Resource<SignUpResponse> {
        return repository.signUp(signUpRequest)
    }

    fun setToken(token: String) {
        viewModelScope.launch {
            repository.setToken(token)
        }
    }

}