package com.tazmans_android.androidmyproject.store

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "token_table")
data class TokenEntity(
    @PrimaryKey
    val id: Int = 0,

    @ColumnInfo(name = "access_token")
    val accessToken: String
)
