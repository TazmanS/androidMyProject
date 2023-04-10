package com.tazmans_android.androidmyproject.api

import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.tazmans_android.androidmyproject.api.response.ErrorResponse
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import retrofit2.HttpException
import retrofit2.Response
import java.io.IOException

abstract class BaseRepo {
    suspend fun <T> safeApiCall(apiToBeCalled: suspend () -> Response<T>): Resource<T> {
        return withContext(Dispatchers.IO) {
            try {
                val response: Response<T> = apiToBeCalled()

                if (response.isSuccessful) {
                    Resource.Success(data = response.body()!!)
                } else {
                    val gson = Gson()
                    val type = object : TypeToken<ErrorResponse>() {}.type
                    val errorResponse: ErrorResponse? =
                        gson.fromJson(response.errorBody()!!.charStream(), type)

                    Resource.Error(
                        message = errorResponse?.message.toString(),
                        data = null
                    )
                }

            } catch (e: HttpException) {
                Resource.Error(message = e.message ?: "Something went wrong")
            } catch (e: IOException) {
                Resource.Error("Please check your network connection")
            } catch (e: Exception) {
                Resource.Error(message = "Something went wrong")
            }
        }
    }
}