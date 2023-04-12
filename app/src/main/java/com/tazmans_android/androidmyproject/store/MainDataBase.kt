package com.tazmans_android.androidmyproject.store

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [TokenEntity::class], version = 1, exportSchema = false)
abstract class MainDataBase : RoomDatabase() {

    abstract fun tokenDao(): TokenDao

    companion object {
        @Volatile
        private var INSTANCE: MainDataBase? = null

        fun getDataBase(context: Context): MainDataBase {
            val tempInstance = INSTANCE
            if (tempInstance != null) {
                return tempInstance
            }

            synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    MainDataBase::class.java,
                    "food_app.db"
                ).build()
                INSTANCE = instance
                return instance
            }
        }
    }
}