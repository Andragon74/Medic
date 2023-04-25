package com.example.medic.data.api

import com.example.medic.data.CatalogModel
import com.example.medic.data.MessageDTO
import com.example.medic.data.NewsModel
import com.example.smartlab.data.source.dto.TokenDTO
import com.google.gson.Gson
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*

class ApiServiceImpl(
    override  val httpClient: HttpClient
) :ApiService {
    override suspend fun getPosts(): List<NewsModel> {

        val gson = Gson()

        val response = httpClient.get("${BASE_URL}/api/news")

        return gson.fromJson(response.bodyAsText(),Array<NewsModel>::class.java).toList()
    }

    override suspend fun getPostsCatalog(): List<CatalogModel> {

        val gson = Gson()

        val response = httpClient.get("${BASE_URL}/api/catalog")

        return gson.fromJson(response.bodyAsText(),Array<CatalogModel>::class.java).toList()
    }

    override suspend fun sendCode(email: String) : MessageDTO  {
        val response :HttpResponse = httpClient.post(){
            url{
                protocol = URLProtocol.HTTPS
                host = "medic.madskill.ru"
                path("api/sendCode")
            }
            header("email",email)
        }
        when (response.status.value) {

            in 200..210 -> {
                return response.body()
            }
            in 300..350 -> {
                throw RedirectResponseException(response, "Code: ${response.status.value}")
            }
            in 400..450 -> {
                throw ClientRequestException(response, "Code: ${response.status.value}")
            }
            else -> {
                throw ServerResponseException(response, "Code: ${response.status.value}")
            }
        }
    }

    override suspend fun signIn(email: String, code: String): TokenDTO {
        val response: HttpResponse = httpClient.post() {
            url {
                protocol = URLProtocol.HTTPS
                host = "medic.madskill.ru"
                path("api/signin")
            }
            headers {
                header("email", email)
                header("code", code)
            }
        }

        when (response.status.value) {

            in 200..210 -> {
                return response.body()
            }
            in 300..350 -> {
                throw RedirectResponseException(response, "Code: ${response.status.value}")
            }
            in 400..450 -> {
                throw ClientRequestException(response, "Code: ${response.status.value}")
            }
            else -> {
                throw ServerResponseException(response, "Code: ${response.status.value}")
            }
        }
    }

    companion object{
        private const val BASE_URL = "https://medic.madskill.ru"
    }
}