package com.example.medic

import android.util.Log
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.medic.desingsystem.component.NiaButton
import com.example.medic.desingsystem.component.NiaTextFleid
import com.example.medic.desingsystem.icon.NiaIcon
import com.example.medic.desingsystem.icon.NiaIcons
import com.example.medic.navigation.navhost.AuthScreen
import com.example.medic.view_model.AuthorizationScreenModel
import org.koin.androidx.compose.koinViewModel

class AuthorizationScreen: Screen {

    @Composable
    override fun Content() {
        AuthorizationScreen1()
    }
}


@Composable

fun AuthorizationScreen1( vm : AuthorizationScreenModel = koinViewModel()) {

    val navigator = LocalNavigator.currentOrThrow

    val authScreen = rememberScreen(provider = AuthScreen.EmailCode)

        var email = vm.email.collectAsState()

        var error by remember {
            mutableStateOf(false)
        }

        fun proverka_email(){
            var cobaka =0
            var tozka=0
            for(i in 0..email.value.length-1){
                if(email.value[i]=='@'){
                    cobaka++
                    Log.d("e","ff")
                }
                if(email.value[i]=='.'){
                    tozka++
                    Log.d("a","11")
                }
            }
            if(cobaka==1 && tozka==1 && email.value.length>=6){
                error= true
                Log.d("z","ok")
            }
            else{
                error=false
            }
        }

        Column(
            Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp, top = 59.dp, bottom = 56.dp)) {
            Column(Modifier.fillMaxWidth()) {
                Row(
                    Modifier
                        .fillMaxWidth()
                        .height(32.dp), verticalAlignment = Alignment.CenterVertically) {
                    NiaIcon(NiaIcons.Ryka, content ="",
                        Modifier
                            .height(32.dp)
                            .width(32.dp))
                    Text(text = "Добро пожаловать!", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.padding(start = 10.dp))
                }
                Text(text = "Войдите, чтобы пользоваться функциями приложения", fontSize = 15.sp, modifier = Modifier.padding(top=23.dp))
                Text(text = "Вход по E-mail", fontSize = 14.sp, color = Color.LightGray,modifier = Modifier.padding(top=64.dp))
                NiaTextFleid(
                    value = email.value,
                    onValueChange = {
                        vm.email.value = it
                        proverka_email()
                    },
                    placeholder = { Text(text = "example@mail.ru") },
                    modifier = Modifier
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                )
                NiaButton(onClick = {
                    vm.getCode()
                    navigator.replace(authScreen)
                                    },
                    enabled = error,
                    modifier = Modifier
                        .padding(top = 32.dp)
                        .fillMaxWidth()
                        .height(56.dp)

                ) {
                    Text(text ="Далее")
                }
                Text(text = "Или войдите с помощью", color= Color.LightGray, modifier = Modifier
                    .align(Alignment.CenterHorizontally)
                    .padding(top = 238.dp))
                Button(onClick = {  },
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = Color.White,
                    ),
                    modifier = Modifier
                        .padding(top = 16.dp)
                        .fillMaxWidth()
                        .height(60.dp)

                ) {
                    Text(text ="Войти с Яндекс ", fontSize = 17.sp,fontWeight = FontWeight.Bold)
                }


            }
        }
}
