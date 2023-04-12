package com.tazmans_android.androidmyproject.store

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface TokenDao {
    @Query("SELECT access_token FROM token_table LIMIT 1")
    fun getToken(): LiveData<String>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun setToken(tokenEntity: TokenEntity)

    @Delete
    suspend fun deleteToken(tokenEntity: TokenEntity)
}