package com.example.medic.authorization

import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.medic.desingsystem.component.NiaButtonAnim
import com.example.medic.desingsystem.icon.NiaIcon
import com.example.medic.desingsystem.icon.NiaIcons
import com.example.medic.navigation.navhost.AuthScreen

class AddPasswordScreen : Screen {

    @Composable
    override fun Content() {
        AddPasswordScreen1()
    }
}


@Preview
@Composable
fun AddPasswordScreen1() {
    var code by remember {
        mutableStateOf("")
    }
    var count =1

    val navigator = LocalNavigator.currentOrThrow

    val authScreen = rememberScreen(provider = AuthScreen.UserCard)

    Column(
        Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 24.dp, bottom = 56.dp), horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text("Пропустить", fontSize = 15.sp, color = Color.Blue, modifier = Modifier.align(Alignment.End).clickable { navigator.replace(authScreen) })
        Text("Создайте пароль", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(top=40.dp))
        Text("Для защиты ваших персональных данных", color = Color.LightGray, fontSize = 15.sp, textAlign = TextAlign.Center, modifier = Modifier.padding(top=16.dp))
        Row(Modifier.padding(top=56.dp)){
            for (i in 0..3) {
                NiaIcon(painter =if (code.length > i) {
                    NiaIcons.IndicatorOn
                } else {
                    NiaIcons.IndicatorOff
                }  ,content = null, tint = Color.Blue ,modifier = Modifier
                    .padding(end = 12.dp)
                    .width(16.dp)
                    .height(16.dp)
                )

            }

        }
        Column(Modifier.padding(top=60.dp)) {
            for (i in 0..3) {
                if (i != 3) {
                    Row(
                        Modifier
                            .fillMaxWidth()
                            .padding(bottom = 24.dp),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        for (j in 1..3) {
                            var a=count
                            NiaButtonAnim(
                                onClick = { if(code.length<4){ code += a.toString()}
                                     }
                                ,modifier = Modifier
                                    .width(80.dp)
                                    .height(80.dp)
                                    .clip(CircleShape)
                            ) {
                                Text(text = (a).toString())
                            }
                            count++
                        }
                    }
                }
                else{
                    Row(
                        Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.SpaceAround
                    ) {
                        Spacer(
                            modifier = Modifier
                                .width(80.dp)
                                .height(80.dp)
                                .clip(CircleShape)
                        )
                        NiaButtonAnim(
                            onClick = { if(code.length<4){ code += 0.toString() }
                                else{
                                    navigator.replace(authScreen)
                                }},

                            modifier = Modifier
                                .width(80.dp)
                                .height(80.dp)
                                .clip(CircleShape)
                        ) {
                            Text(text = 0.toString())
                        }
                        NiaButtonAnim(
                            onClick = {
                                code=code.replaceFirst(".$".toRegex(), "")
                                Log.d("ee",code)
                            },
                            modifier = Modifier
                                .background(Color.Transparent)
                                .width(80.dp)
                                .height(80.dp)
                                .clip(CircleShape)
                        ) {
                            NiaIcon(NiaIcons.BackSpase, content ="", modifier = Modifier.background(
                                Color.Transparent) )
                        }
                    }
                }
            }
        }
    }
}
