package com.example.medic.navigation.navhost

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class MainScreen : ScreenProvider {
    object mainScreem : MainScreen()
    object profilScreen : MainScreen()
}