package com.example.medic.data


import com.google.gson.annotations.SerializedName

data class MessageDTO(
    @SerializedName("message")
    val message: String
)