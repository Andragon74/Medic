package com.example.medic.di

import com.example.medic.main.ProfilViewModel
import com.example.medic.view_model.AuthorizationScreenModel
import com.example.medic.view_model.MainScreenModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val AppModule = module {

    includes(ApiModule)

    single {
        MainScreenModel(get())
    }
    single {

        AuthorizationScreenModel(get())
    }
    factory {

    }

    viewModel {

        ProfilViewModel()

    }

}