package com.tazmans_android.androidmyproject.fragments

import androidx.appcompat.app.AppCompatActivity
import com.tazmans_android.androidmyproject.R

object FragmentManager {

    fun setFragment(newFragment: BaseFragment, activity: AppCompatActivity) {
        val transition = activity.supportFragmentManager.beginTransaction()
        transition.replace(R.id.placeholder, newFragment)
        transition.commit()
    }
}