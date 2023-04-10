package com.tazmans_android.androidmyproject.store

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TokenEntity::class], version = 1)
abstract class MainDataBase : RoomDatabase() {

    abstract fun getTokenDao(): TokenDao

    companion object {
        @Volatile
        private var INSTANCE: MainDataBase? = null
        fun getDataBase(context: Context): MainDataBase {
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDataBase::class.java,
                    "food_app.db"
                ).build()
                instance
            }
        }
    }
}