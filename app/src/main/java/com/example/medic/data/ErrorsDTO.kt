package com.example.medic.data


import com.google.gson.annotations.SerializedName

data class ErrorsDTO(
    @SerializedName("errors")
    val errors: String
)

data class ErrorsListDTO(
    @SerializedName("errors")
    val errors: List<String>
)