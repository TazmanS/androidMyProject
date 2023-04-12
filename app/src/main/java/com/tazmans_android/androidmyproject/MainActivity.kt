package com.tazmans_android.androidmyproject

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private val mMainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        val token = MainViewModel(this@MainActivity.application).token

        mMainViewModel.token.observeForever {
            Log.v("MyTag", it.size.toString())
//            if (it.isNotEmpty()) {
//                val token = it[0]
//                Log.v("MyTag", token.toString())
//            }
        }
    }
}