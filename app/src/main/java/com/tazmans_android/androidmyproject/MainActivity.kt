package com.tazmans_android.androidmyproject

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import com.tazmans_android.androidmyproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val mMainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        listenToken()
    }

    private fun listenToken() {
        mMainViewModel.token.observe(this) {
            val token = it[0]
            if (token.isNotEmpty()) {

            }

            Log.v("MyTag", token)
        }
    }
}