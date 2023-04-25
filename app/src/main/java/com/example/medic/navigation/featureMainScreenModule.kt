package com.example.medic.navigation

import cafe.adriel.voyager.core.registry.screenModule
import com.example.medic.AuthorizationScreen
import com.example.medic.authorization.AddPasswordScreen
import com.example.medic.authorization.CodeFromEmailScreen
import com.example.medic.main.MainScreen1
import com.example.medic.main.mainScreen1
import com.example.medic.main.profilScreen1
import com.example.medic.navigation.navhost.AuthScreen
import com.example.medic.navigation.navhost.MainScreen

val featureMainScreenModule = screenModule {

    register<MainScreen.mainScreem> {
        mainScreen1()
    }

    register<MainScreen.profilScreen> {
        profilScreen1()
    }

//    register<AuthScreen.EmailCode> {
//        CodeFromEmailScreen()
//    }

}