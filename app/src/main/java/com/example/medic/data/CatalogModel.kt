package com.example.medic.data


import com.google.gson.annotations.SerializedName

data class CatalogModel(
    @SerializedName("bio")
    val bio: String,
    @SerializedName("category")
    val category: String,
    @SerializedName("description")
    val description: String,
    @SerializedName("id")
    val id: Int,
    @SerializedName("name")
    val name: String,
    @SerializedName("preparation")
    val preparation: String,
    @SerializedName("price")
    val price: String,
    @SerializedName("time_result")
    val timeResult: String
)