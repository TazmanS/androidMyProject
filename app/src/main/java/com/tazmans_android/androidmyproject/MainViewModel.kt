package com.tazmans_android.androidmyproject

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import com.tazmans_android.androidmyproject.api.Resource
import com.tazmans_android.androidmyproject.api.request.SignInRequest
import com.tazmans_android.androidmyproject.api.request.SignUpRequest
import com.tazmans_android.androidmyproject.api.response.SignInResponse
import com.tazmans_android.androidmyproject.api.response.SignUpResponse
import com.tazmans_android.androidmyproject.store.MainDataBase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(application: Application) : AndroidViewModel(application) {
    private val tokenDao = MainDataBase.getDataBase(application).tokenDao()

    private val repository: MainRepository = MainRepository(tokenDao)
    val token: LiveData<String> = repository.token

    suspend fun signUp(signUpRequest: SignUpRequest): Resource<SignUpResponse> {
        return repository.signUp(signUpRequest)
    }

    suspend fun signIn(signInRequest: SignInRequest): Resource<SignInResponse> {
        return repository.signIn(signInRequest)
    }

    fun setToken(token: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.setToken(token)
        }
    }

    fun deleteToken() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deleteToken()
        }
    }

}