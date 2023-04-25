package com.example.medic.authorization

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.medic.desingsystem.icon.NiaIcon
import com.example.medic.desingsystem.icon.NiaIcons
import com.example.medic.desingsystem.theme.Fon_TextFleid
import com.example.medic.navigation.navhost.AuthScreen
import com.example.medic.view_model.AuthorizationScreenModel
import kotlinx.coroutines.*
import org.koin.androidx.compose.koinViewModel

class CodeFromEmailScreen: Screen {

    @Composable
    override fun Content() {
        CodeFromEmailScreen1()
    }
}



@SuppressLint("StateFlowValueCalledInComposition", "CoroutineCreationDuringComposition")
@Composable
fun CodeFromEmailScreen1(vm:AuthorizationScreenModel = koinViewModel()) {

    var time = vm.timer.collectAsState()

    val navigator = LocalNavigator.currentOrThrow

    val PasswordScreen = rememberScreen(provider = AuthScreen.AddPassword)

    val timerStart = CoroutineScope(Dispatchers.IO).launch(start = CoroutineStart.LAZY) {
        vm.startTimer()
    }

    LaunchedEffect(true ){
        vm.startTimer()
    }
    var code = vm.code.collectAsState()
    val ErrorCode = vm.ErrorCode.collectAsState()

    Column(
        Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 24.dp, bottom = 56.dp)
    ) {
        Button(
            onClick = { /*TODO*/ },
            colors = ButtonDefaults.buttonColors(
                backgroundColor = Fon_TextFleid
            ),
            contentPadding = PaddingValues(0.dp),
            modifier = Modifier
                .width(32.dp)
                .height(32.dp)
                .clip(RoundedCornerShape(8.dp))
        ) {
            NiaIcon(NiaIcons.Back, content = " ")
        }
        Column(
            Modifier
                .fillMaxSize()
                .padding(top = 132.dp), horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text("Введите код из E-mail", fontSize = 17.sp, fontWeight = FontWeight.Bold)
            Box(
                Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth()
                    .height(48.dp)
            ) {
                TextField(
                    value = code.value,
                    onValueChange = {
                        if (it.length < 5) {
                            vm.code.value = it
                            if(it.length==4){
                                vm.postCode()
                            }

                        }
                        else{

                            navigator.push(PasswordScreen)
                        }
                    },
                    keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.NumberPassword),
                    shape = RoundedCornerShape(20.dp),
                    maxLines = 1,
                    colors = TextFieldDefaults.textFieldColors(
                        textColor = Color.Transparent,
                        cursorColor = Color.Transparent,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                        disabledIndicatorColor = Color.Transparent,
                        backgroundColor = Color.White

                    ),
                    modifier = Modifier.fillMaxWidth()
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .fillMaxHeight()
                    ,
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Center
                ) {
                    for (i in 0..3) {
                        Column(
                            horizontalAlignment = Alignment.CenterHorizontally,
                            modifier = Modifier.padding(end = 8.dp)
                        ) {
                            Box(modifier = Modifier
                                .height(48.dp)
                                .width(48.dp)
                                .clip(
                                    RoundedCornerShape(10.dp)
                                )
                                .background(Fon_TextFleid), contentAlignment = Alignment.Center) {


                                Text(
                                    text = if (code.value.length > i) {
                                        code.value[i].toString()
                                    } else {
                                        " "
                                    }, fontSize = 20.sp
                                )
                            }
                        }
                    }
                }
            }

            if(time.value > 0) {
                Text("Отправить код повторно можно будет через ${time.value} секунд",
                    color = if(ErrorCode.value){Color.Red}else{Color.LightGray},
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center, modifier = Modifier
                        .padding(top = 16.dp)
                        .height(40.dp)
                        .width(242.dp)
                        .clickable {

                        })
            }
            else {
                Text("Отправить еще раз",
                    color = if(ErrorCode.value){Color.Red}else{Color.LightGray},
                    fontSize = 15.sp,
                    textAlign = TextAlign.Center, modifier = Modifier
                        .padding(top = 16.dp)
                        .height(40.dp)
                        .width(242.dp)
                        .clickable {
                            if (time.value == 0) {
                                vm.getCode()
                                timerStart.start()
                            }
                        })

            }

        }
    }
}