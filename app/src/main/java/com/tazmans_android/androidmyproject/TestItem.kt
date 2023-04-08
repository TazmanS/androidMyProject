package com.tazmans_android.androidmyproject

import com.google.gson.annotations.SerializedName

data class TestItem(
    @SerializedName("title")
    var title: String,
    @SerializedName("userId")
    var userId: Int,
    @SerializedName("id")
    var id: Int,
    @SerializedName("body")
    var body: String
)
