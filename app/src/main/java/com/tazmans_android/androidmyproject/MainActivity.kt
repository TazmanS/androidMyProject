package com.tazmans_android.androidmyproject

import android.os.Bundle
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController

class MainActivity : AppCompatActivity() {

    private val mMainViewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mMainViewModel.token.observe({ lifecycle }) {
            if (!it.isNullOrEmpty()) {
                goToHome()
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
}