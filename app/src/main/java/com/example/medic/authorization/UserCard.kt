package com.example.medic.authorization

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.registry.rememberScreen
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.navigator.LocalNavigator
import cafe.adriel.voyager.navigator.currentOrThrow
import com.example.medic.AuthorizationScreen1
import com.example.medic.desingsystem.component.Calendar
import com.example.medic.desingsystem.component.ComboBox
import com.example.medic.desingsystem.component.NiaTextFleid
import com.example.medic.navigation.navhost.AuthScreen
import com.example.medic.navigation.navhost.MainScreen
import java.util.*


class UserCard: Screen {

    @Composable
    override fun Content() {
        AddCard()
    }
}

@Preview(showBackground = false, showSystemUi = false)
@Composable
fun AddCard(){

    val navigator = LocalNavigator.currentOrThrow

    val authScreen = rememberScreen(provider = MainScreen.mainScreem)

    var showCalendar by remember {
        mutableStateOf(false)
    }
    var Name by remember {
        mutableStateOf("")
    }
    var SurName by remember {
        mutableStateOf("")
    }
    var Otzectvo by remember {
        mutableStateOf("")
    }
    var Pol by remember {
        mutableStateOf("")
    }
    var Data by remember {
        mutableStateOf("")
    }
    Column(
        Modifier
            .fillMaxSize()
            .padding(start = 20.dp, end = 20.dp, top = 24.dp, bottom = 32.dp), horizontalAlignment = Alignment.CenterHorizontally
    ){
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
            Text("Создание карты пациента", fontSize = 24.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(0.6f))
            Text("Пропустить", fontSize = 15.sp, color = Color.Blue, modifier = Modifier.clickable { navigator.replaceAll(authScreen) })
        }
        Text("Без карты пациента вы не сможете заказать анализы. ", color = Color.LightGray, fontSize = 13.8.sp, modifier = Modifier
            .align(Alignment.End)
            .padding(top = 16.dp)
            .fillMaxWidth())
        Text("В картах пациентов будут храниться результаты анализов вас и ваших близких.", color = Color.LightGray, fontSize = 13.8.sp, modifier = Modifier
            .padding(top = 16.dp)
            .align(Alignment.End))
        Column(
            Modifier
                .fillMaxWidth()
                .padding(top = 32.dp)) {
            NiaTextFleid(
                value = SurName,
                onValueChange = {
                    SurName = it
                },

                placeholder = { Text(text = "Фамилия") },
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
            )
            NiaTextFleid(
                value = Name,
                onValueChange = {
                    Name = it
                },
                placeholder = { Text(text = "Имя") },
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
            )
            NiaTextFleid(
                value = Otzectvo,
                onValueChange = {
                    Otzectvo = it
                },
                placeholder = { Text(text = "Отчество") },
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
            )
            NiaTextFleid(
                value = Data,
                onValueChange = {
                },
                enabled = false,
                placeholder = { Text(text = "Дата рождения") },
                modifier = Modifier
                    .padding(bottom = 24.dp)
                    .fillMaxWidth()
                    .clip(RoundedCornerShape(10.dp))
                    .clickable { showCalendar = !showCalendar }
            )
            Data=Calendar(showCalendar )
            showCalendar=false
            Box(Modifier.fillMaxWidth()){}
            ComboBox()
            
        }
    }
}