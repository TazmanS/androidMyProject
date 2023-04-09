package com.tazmans_android.androidmyproject.api.request

data class SignUpRequest(
    var login: String,
    var password: String,
    var email: String,
    var keep_me: Boolean,
    var email_me: Boolean
)
