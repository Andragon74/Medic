package com.example.medic.desingsystem.component

import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medic.desingsystem.icon.NiaIcon
import com.example.medic.desingsystem.icon.NiaIcons

@Composable
fun BottomNavigationq1 () {
    Row(
        Modifier
            .padding(start = 7.dp, end = 7.dp)
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween ){
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            NiaIcon(NiaIcons.Analiz, content = "",)
            Text(text = "Анализы", fontSize = 12.sp)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            NiaIcon(NiaIcons.Result, content = "")
            Text(text = "Результаты", fontSize = 12.sp)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            NiaIcon(NiaIcons.Messager, content = "")
            Text(text = "Поддержка", fontSize = 12.sp)
        }
        Column(horizontalAlignment = Alignment.CenterHorizontally) {
            NiaIcon(NiaIcons.User, content = "")
            Text(text = "Профиль", fontSize = 12.sp)
        }
    }
}

@Preview
@Composable
fun PreviewBottomNavigation(){
    //BottomNavigation()
}