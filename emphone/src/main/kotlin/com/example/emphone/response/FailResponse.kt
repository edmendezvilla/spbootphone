package com.example.emphone.response

data class FailResponse(
    val status: String = "fail",
    val data: Any? = null
)