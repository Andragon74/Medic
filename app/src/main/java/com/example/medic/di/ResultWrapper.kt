package com.example.medic.di

import android.util.Log
import com.example.medic.data.ErrorsDTO
import com.example.medic.data.ErrorsListDTO
import com.example.smartlab.data.source.dto.TokenDTO
import com.google.gson.Gson
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.statement.*
import io.ktor.serialization.*
import io.ktor.utils.io.errors.*
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.withContext
import java.util.*

sealed class Result<out T : Any> {
    data class Success<out T : Any>(val value: T) : Result<T>()
    data class Error(val message: String) : Result<Nothing>()
    object Loading : Result<Nothing>()
}

sealed class ResultWrapper<out T> {
    data class Success<out T>(val value: T) : ResultWrapper<T>()
    data class GenericError(val error: String? = null) :
        ResultWrapper<Nothing>()

    object NetworkError : ResultWrapper<Nothing>()
}

suspend fun <T> safeApiCall(
    dispatcher: CoroutineDispatcher,
    apiCall: suspend () -> T
): ResultWrapper<T> {
    return withContext(dispatcher) {
        try {
            ResultWrapper.Success(apiCall.invoke())
        } catch (throwable: Throwable) {
            when (throwable) {
                is IOException -> ResultWrapper.NetworkError
                is ClientRequestException -> {
                    try {
                        val errorResponse: ErrorsDTO = throwable.response.body()
                        ResultWrapper.GenericError(errorResponse.errors.toString())
                    }
                    catch (e: JsonConvertException) {
                        val errorResponse: ErrorsListDTO = throwable.response.body()
                        ResultWrapper.GenericError(errorResponse.errors[0])
                    }
                }
                is RedirectResponseException -> {
                    ResultWrapper.GenericError(throwable.response.status.value.toString())
                }
                is ServerResponseException -> {
                    ResultWrapper.GenericError(throwable.response.status.value.toString())
                }
                else -> {
                    ResultWrapper.GenericError(null)
                }
            }
        }
    }
}