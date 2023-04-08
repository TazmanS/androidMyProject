package com.tazmans_android.androidmyproject.ui.auth

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import com.tazmans_android.androidmyproject.TestItem
import com.tazmans_android.androidmyproject.databinding.FragmentAuthSignUpBinding
import kotlinx.coroutines.launch
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET


class AuthSignUpFragment : Fragment() {
    private var _binding: FragmentAuthSignUpBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAuthSignUpBinding.inflate(inflater, container, false)

//        val retrofitBuilder = Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/")
//            .addConverterFactory(GsonConverterFactory.create())
//
//        val okHttpBuilder = OkHttpClient.Builder()
//            .readTimeout(5, TimeUnit.SECONDS)
//            .connectTimeout(2, TimeUnit.SECONDS)
//
//        val publicApi = retrofitBuilder
//            .client(okHttpBuilder.build())
//            .build()
//            .create(JSONPlaceHolderApi::class.java)
//
//        val response = publicApi.getTest()
//
//        Log.v("MyTag", response.toString())

        var retrofit =
            Retrofit.Builder().baseUrl("https://jsonplaceholder.typicode.com/").addConverterFactory(
                GsonConverterFactory.create()
            ).build()

        var service = retrofit.create(JSONPlaceHolderApi::class.java)


        lifecycleScope.launch {
            var response = service.getTest()

            Log.v("MyTag", response.body().toString())
        }


        return binding.root
    }


    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}

interface JSONPlaceHolderApi {
    @GET("posts/1")
    suspend fun getTest(): Response<TestItem>
}