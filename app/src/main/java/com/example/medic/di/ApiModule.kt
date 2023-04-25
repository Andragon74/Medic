package com.example.medic.di

import com.example.medic.data.api.ApiService
import com.example.medic.data.api.ApiServiceImpl
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.serialization.gson.*
import org.koin.dsl.module


val ApiModule = module {


	single<ApiService> {
		ApiServiceImpl(get())
	}

	single<ApiRepository> {
		ApiRepositoryImpl(get())
	}

	single {
		HttpClient(Android) {
			install(ContentNegotiation){
				gson()
			}
		}
	}

}