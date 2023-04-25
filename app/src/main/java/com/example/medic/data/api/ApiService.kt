package com.example.medic.data.api

import com.example.medic.data.CatalogModel
import com.example.medic.data.MessageDTO
import com.example.medic.data.NewsModel
import com.example.medic.di.ResultWrapper
import com.example.smartlab.data.source.dto.TokenDTO
import io.ktor.client.*

interface ApiService {

    val httpClient : HttpClient

    suspend fun  getPosts() : List<NewsModel>

    suspend fun  getPostsCatalog() : List<CatalogModel>

    suspend fun sendCode(email: String) : MessageDTO

    suspend fun signIn(email: String, code: String): TokenDTO
}