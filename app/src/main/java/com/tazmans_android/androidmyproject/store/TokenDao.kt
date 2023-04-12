package com.tazmans_android.androidmyproject.store

import androidx.lifecycle.LiveData
import androidx.room.*


@Dao
interface TokenDao {
    @Query("SELECT * FROM token_table")
    fun getToken(): LiveData<List<TokenEntity>>

    //    @Insert(onConflict = OnConflictStrategy.REPLACE)
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun setToken(tokenEntity: TokenEntity)

    @Delete
    suspend fun deleteToken(tokenEntity: TokenEntity)
}