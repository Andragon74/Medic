package com.example.medic.navigation.navhost

import cafe.adriel.voyager.core.registry.ScreenProvider

sealed class AuthScreen : ScreenProvider {

    object AddPassword: AuthScreen()

    object Authorization: AuthScreen()

    object EmailCode: AuthScreen()

    object UserCard : AuthScreen()

}