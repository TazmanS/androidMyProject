package com.tazmans_android.androidmyproject.entity

data class SignUpData(
    var login: String,
    var password: String,
    var email: String,
    var keep_me: Boolean,
    var email_me: Boolean
)
