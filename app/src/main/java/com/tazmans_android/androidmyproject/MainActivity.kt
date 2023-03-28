package com.tazmans_android.androidmyproject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.tazmans_android.androidmyproject.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

//        val navHostFragment =
//            supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
//        val navController = navHostFragment.navController
//
//        setupActionBarWithNavController(navController)
    }

//    override fun onSupportNavigateUp(): Boolean {
//        val navController = findNavController(R.id.navHostFragment)
//        return navController.navigateUp() || super.onSupportNavigateUp()
//    }
}