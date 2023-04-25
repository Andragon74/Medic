package com.example.medic.di

import com.example.medic.data.CatalogModel
import com.example.medic.data.MessageDTO
import com.example.medic.data.NewsModel
import com.example.medic.data.api.ApiService
import com.example.smartlab.data.source.dto.TokenDTO
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow


class ApiRepositoryImpl(
    private  val apiService: ApiService
):ApiRepository {

    override  fun getPosts(): Flow<List<NewsModel>> = flow {
        val result = apiService.getPosts()
        emit(result)
    }

    override  fun getPostsCatalog(): Flow<List<CatalogModel>> = flow {
        val result = apiService.getPostsCatalog()
        emit(result)
    }

    override suspend fun sendCode(email: String) : ResultWrapper<MessageDTO> {
        return safeApiCall(Dispatchers.IO) {
            apiService.sendCode(email)
        }
    }
    override suspend fun signIn(email: String, code: String): ResultWrapper<TokenDTO> {
        return safeApiCall(Dispatchers.IO) {
            apiService.signIn(email, code)
        }
    }

}