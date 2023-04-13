package com.tazmans_android.androidmyproject.api.response

data class ProfileResponse(
    var _id: String,
    val login: String,
    val email: String,
    val role: Int,
    val keep_me: Boolean,
    val email_me: Boolean,
    val createdAt: String,
    val updatedAt: String,
)
