package com.example.medic.di

import com.example.medic.data.CatalogModel
import com.example.medic.data.MessageDTO
import com.example.medic.data.NewsModel
import com.example.smartlab.data.source.dto.TokenDTO
import kotlinx.coroutines.flow.Flow

interface ApiRepository {
    fun getPosts(): Flow<List<NewsModel>>

    fun getPostsCatalog(): Flow<List<CatalogModel>>

    suspend fun sendCode(email: String) : ResultWrapper<MessageDTO>

    suspend fun signIn(email: String, code: String): ResultWrapper<TokenDTO>
}