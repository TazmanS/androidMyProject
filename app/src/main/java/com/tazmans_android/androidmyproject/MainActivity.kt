package com.tazmans_android.androidmyproject

import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.lifecycleScope
import androidx.navigation.findNavController
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {

    private val mMainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMainViewModel.token.observe({ lifecycle }) {
            if (!it.isNullOrEmpty()) {
                goToHome()
                getProfile()
            } else {
                goToLogin()
            }
        }
    }

    private fun goToLogin() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.preLoaderFragment)
    }

    private fun goToHome() {
        findNavController(R.id.nav_host_fragment).navigate(R.id.homeFragment)
    }

    private fun getProfile() {
        lifecycleScope.launch {
            val res = mMainViewModel.getProfile()
            Log.v("MyTag", res.data.toString())
        }
    }
}