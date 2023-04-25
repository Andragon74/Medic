package com.example.medic.core.ui

import android.icu.text.ListFormatter.Width
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medic.desingsystem.component.*
import com.example.medic.desingsystem.icon.NiaIcon
import com.example.medic.desingsystem.icon.NiaIcons

@Composable
fun CardOformlenie (){
}

@Composable
@Preview
fun CardAdress(){
    var Adress by remember {
        mutableStateOf("")
    }
    var Domofon by remember {
        mutableStateOf("")
    }
    var Dolgota by remember {
        mutableStateOf("")
    }
    var Width by remember {
        mutableStateOf("")
    }
    var Height by remember {
        mutableStateOf("")
    }
    var Kvartira by remember {
        mutableStateOf("")
    }
    var Podezd by remember {
        mutableStateOf("")
    }
    var Edag by remember {
        mutableStateOf("")
    }
    val checkedState = remember { mutableStateOf(false) }
    var Note by remember {
        mutableStateOf("")
    }
    Column(
        Modifier
            .padding(start = 20.dp, end = 20.dp, bottom = 32.dp, top = 24.dp)
            .fillMaxWidth()) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Адресс сдачи анализов", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(0.7f))
            NiaIcon(NiaIcons.Karta, content =null ,)
        }
        Column(
            Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()) {
            Text(text = "Ваш адрес", fontSize = 14.sp,color= Color.LightGray)
            NiaTextFleid(value = Adress , onValueChange ={Adress = it},Modifier.fillMaxWidth())
        }
        Row(
            Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .background(Color.Red), horizontalArrangement = Arrangement.SpaceBetween) {
            Column(Modifier.fillMaxWidth(0.3f)) {
                Text(text = "Долгота", fontSize = 14.sp,color= Color.LightGray)
                NiaTextFleid(value = Dolgota , onValueChange ={Dolgota = it})
            }
            Column(Modifier.fillMaxWidth(0.5f)) {
                Text(text = "Ширина", fontSize = 14.sp,color= Color.LightGray)
                NiaTextFleid(value = Width , onValueChange ={Width = it})
            }
            Column(Modifier.fillMaxWidth(0.45f)) {
                Text(text = "Высота", fontSize = 14.sp,color= Color.LightGray)
                NiaTextFleid(value = Height , onValueChange ={Height = it})
            }
        }
        Row(
            Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()
                .background(Color.Red), horizontalArrangement = Arrangement.SpaceBetween) {
            Column(Modifier.width(100.dp)) {
                Text(text = "Квартира", fontSize = 14.sp,color= Color.LightGray)
                NiaTextFleid(value = Kvartira , onValueChange ={Kvartira = it})
            }
            Column(Modifier.width(100.dp)) {
                Text(text = "Подъезд", fontSize = 14.sp,color= Color.LightGray)
                NiaTextFleid(value = Podezd , onValueChange ={Podezd = it})
            }
            Column(Modifier.width(100.dp)) {
                Text(text = "Этаж", fontSize = 14.sp,color= Color.LightGray)
                NiaTextFleid(value = Edag , onValueChange ={Edag = it})
            }
        }
        Column(
            Modifier
                .padding(top = 16.dp)
                .fillMaxWidth()) {
            Text(text = "Ваш адрес", fontSize = 14.sp,color= Color.LightGray)
            NiaTextFleid(value =Domofon , onValueChange ={Adress=it},Modifier.fillMaxWidth())
        }
        Row(
            Modifier
                .padding(top = 10.dp)
                .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Сохранить этот адрес?", fontSize = 16.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(0.7f))
            checkedState.value = SwitchBox(
                modifier = Modifier
                    .width(48.dp)
                    .height(28.dp),
                checked = checkedState.value,
            )
        }
        AnimatedVisibility(visible = checkedState.value) {
            NiaTextFleid(value =Note , onValueChange ={ Note = it} , placeholder = { Text(text = "Название: например дом, работа")}, modifier = Modifier.fillMaxWidth())
        }
        NiaButton(onClick = { /*TODO*/ },
        modifier = Modifier
            .padding(
                top = if (checkedState.value == false) {
                    22.dp
                } else {
                    30.dp
                }
            )
            .fillMaxWidth()
            .height(56.dp)) {
            Text(text = "Подтвердить")
        }
    }
}
@Preview
@Composable
fun CardTime(){
    var NomerButton by remember {
        mutableStateOf(0)
    }
    Column(
        Modifier
            .padding(start = 20.dp, end = 20.dp, bottom = 32.dp, top = 24.dp)
            .fillMaxWidth()) {
        Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween) {
            Text("Дата и время", fontSize = 20.sp, fontWeight = FontWeight.Bold, modifier = Modifier.fillMaxWidth(0.7f))
            NiaIcon(NiaIcons.Karta, content =null ,)
        }
        Column(
            Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()) {
            Text(text = "Выберите дату", fontSize = 14.sp,color= Color.LightGray)
            DataComboBox(Modifier.padding(top=16.dp))
        }
        Column(Modifier.padding(top=32.dp)) {
            Text(text = "Выберите время", fontSize = 16.sp, color = Color.Gray )
            Row(Modifier.padding(top=16.dp).fillMaxWidth() , horizontalArrangement = Arrangement.SpaceBetween) {
                NiaButtonTime(
                    id=1,
                    NomerButton = NomerButton,
                    onClick = { NomerButton=1 }
                ) {
                    Text(text = "10:00")
                }
                NiaButtonTime(
                    id=2,
                    NomerButton = NomerButton,
                    onClick = { NomerButton=2 }
                ) {
                    Text(text = "13:00")
                }
                NiaButtonTime(
                    id=3,
                    NomerButton = NomerButton,
                    onClick = { NomerButton=3 }
                ) {
                    Text(text = "14:00")
                }
                NiaButtonTime(
                    id=4,
                    NomerButton = NomerButton,
                    onClick = { NomerButton=4 }
                ) {
                    Text(text = "15:00")
                }
            }
            Row(Modifier.padding(top=16.dp).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween) {
                NiaButtonTime(
                    id=5,
                    NomerButton = NomerButton,
                    onClick = { NomerButton=5 }
                ) {
                    Text(text = "16:00")
                }
                NiaButtonTime(
                    id=6,
                    NomerButton = NomerButton,
                    onClick = { NomerButton=6 }
                ) {
                    Text(text = "18:00")
                }
                NiaButtonTime(
                    id=7,
                    NomerButton = NomerButton,
                    onClick = { NomerButton=7 }
                ) {
                    Text(text = "19:00")
                }
                Spacer(modifier = Modifier.width(72.dp).height(20.dp))
            }
        }
        NiaButton(
            onClick = { /*TODO*/ },
            modifier = Modifier
                .padding(
                    top = 48.dp
                )
                .fillMaxWidth()
                .height(56.dp)) {
            Text(text = "Подтвердить")
        }
    }
}