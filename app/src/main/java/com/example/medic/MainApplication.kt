package com.example.medic

import android.app.Application
import cafe.adriel.voyager.core.registry.ScreenRegistry
import com.example.medic.di.AppModule
import com.example.medic.navigation.featureAuthScreenModule
import com.example.medic.navigation.featureMainScreenModule
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MainApplication : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {

            androidContext(this@MainApplication)

            modules(AppModule)
        }

        ScreenRegistry {
            featureAuthScreenModule()
            featureMainScreenModule()
        }
    }
}