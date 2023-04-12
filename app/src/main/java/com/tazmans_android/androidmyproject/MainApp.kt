package com.tazmans_android.androidmyproject

import android.app.Application

class MainApp : Application() {

//    override fun onCreate() {
//        super.onCreate()
//
//        val tokenDao = MainDataBase.getDataBase(this).getTokenDao()
//
//        val token = tokenDao.getToken()
//        token.observeForever {
//            if (it.isNotEmpty()) {
//                val token = it[0]
//                Log.v("MyTag", token.toString())
//            }
//
//            Log.v("MyTag", "token = null")
//        }
//    }
}