package com.example.smartlab.data.source.dto


import com.google.gson.annotations.SerializedName

data class TokenDTO(
    @SerializedName("token")
    val token: String
)