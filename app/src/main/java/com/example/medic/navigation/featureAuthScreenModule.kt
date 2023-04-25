package com.example.medic.navigation

import cafe.adriel.voyager.core.registry.screenModule
import com.example.medic.AuthorizationScreen
import com.example.medic.authorization.AddPasswordScreen
import com.example.medic.authorization.CodeFromEmailScreen
import com.example.medic.authorization.UserCard
import com.example.medic.navigation.navhost.AuthScreen

val featureAuthScreenModule = screenModule {

    register<AuthScreen.Authorization> {
        AuthorizationScreen()
    }

    register<AuthScreen.AddPassword> {
        AddPasswordScreen()
    }

    register<AuthScreen.EmailCode> {
        CodeFromEmailScreen()
    }

    register<AuthScreen.UserCard> {
        UserCard()
    }

}