@file:OptIn(ExperimentalFoundationApi::class)

package com.example.medic.on_board

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import com.example.medic.R
import com.example.medic.desingsystem.icon.NiaIcon
import com.example.medic.desingsystem.icon.NiaIcons
import com.example.medic.navigation.navhost.AuthScreen

class OnBoardingScreen : Screen {

    @OptIn(ExperimentalFoundationApi::class)
    @Composable
    override fun Content() {
        OnBordingScreen()
    }
}


@OptIn(ExperimentalFoundationApi::class)
@Composable
fun OnBordingScreen(){

    val navigator = LocalNavigator.currentOrThrow

    val authScreen = rememberScreen(provider = AuthScreen.Authorization)


    val pagerState = rememberPagerState()
    var massiv :List<String> = listOf("Анализы","Уведомления","Мониторинг")
    var massiv1 :List<String> = listOf("Экспресс сбор и получение проб","Вы быстро узнаете о результатах","Наши врачи всегда наблюдают \n" + "за вашими показателями здоровья")
    var Image:List<Int> = listOf(R.drawable.image2, R.drawable.image1, R.drawable.image3)
    Column(Modifier.fillMaxSize()) {
        Row(
            verticalAlignment = Alignment.Top,
            horizontalArrangement = Arrangement.End,
            modifier = Modifier
                .fillMaxHeight(0.2f)
                .fillMaxWidth()
        ) {
            Text(if (pagerState.currentPage == 2) {
                "Завершить"
            } else {
                "Пропустить"
            }, fontSize = 20.sp, modifier = Modifier
                .padding(end = 67.dp)
                .clickable {
                    if (pagerState.currentPage < 2) {
                        CoroutineScope(Dispatchers.Main).launch {
                            pagerState.scrollToPage(2)
                        }
                    } else {
                       navigator.replaceAll(authScreen)
                    }
                })
            Image(
                painter = painterResource(R.drawable.logo1),
                contentDescription = null,
                modifier = Modifier
                    .width(163.dp)
                    .height(163.dp)
            )
        }
        Box(contentAlignment = Alignment.TopCenter) {
            Row(Modifier.padding(top=161.dp),horizontalArrangement = Arrangement.Center ){
                for(i in 0..2){
                    NiaIcon(if (i == pagerState.currentPage) {
                        NiaIcons.IndicatorOn
                    }
                    else {
                        NiaIcons.IndicatorOff
                    },content = null, tint = Color.Blue, modifier = Modifier.padding(end=8.dp)

                    )
                }
            }
            HorizontalPager(
                modifier = Modifier
                    .padding(top = 50.dp)
                    .fillMaxHeight(1f)
                    //   .background(Color.Red)
                    .fillMaxWidth(), pageCount = 3, state = pagerState
            ) {
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    Box() {
                        Column(
                            Modifier.height(120.dp),
                            horizontalAlignment = Alignment.CenterHorizontally
                        ) {
                            Text(
                                massiv[it],
                                fontSize = 20.sp,
                                textAlign = TextAlign.Center,
                                color = Color.Green
                            )
                            Text(
                                massiv1[it],
                                fontSize = 14.sp,
                                textAlign = TextAlign.Center,
                                color = Color.LightGray,
                                modifier = Modifier.padding(top = 29.dp)
                            )
                        }
                    }
                    Image(
                        painterResource(Image[it]),
                        contentDescription = "",
                        contentScale = ContentScale.Fit,
                        modifier = Modifier
                            .padding(top = 182.dp)
                            .height(217.dp)
                            .fillMaxWidth()
                        //          .background(Color.Blue)
                    )
                }
            }
        }
    }
}