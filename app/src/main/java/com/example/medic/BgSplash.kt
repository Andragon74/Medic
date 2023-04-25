package com.example.medic

import android.annotation.SuppressLint
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.medic.on_board.OnBoardingScreen

import kotlinx.coroutines.delay


class BgSplash: Screen{

    @Composable
    override fun Content() {

        val navigator = LocalNavigator.currentOrThrow

        Box(Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
            Image(painter = painterResource(id = R.drawable.fon), contentDescription ="",
                Modifier.fillMaxSize(), contentScale = ContentScale.FillBounds )
            Image(painter = painterResource(id = R.drawable.name), contentDescription ="" )
        }

        LaunchedEffect(key1 = true) {
            delay(3000)
            navigator.replaceAll(OnBoardingScreen())
        }

    }

}