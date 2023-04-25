package com.example.medic.main.shoping

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

import com.example.medic.desingsystem.component.NiaButton
import com.example.medic.desingsystem.component.NiaButtonAnim
import com.example.medic.desingsystem.icon.NiaIcon
import com.example.medic.desingsystem.icon.NiaIcons
import com.example.medic.desingsystem.theme.Fon_TextFleid

@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ShoppingCartScreen() {

    val state = rememberLazyListState()
    var scroll = rememberScrollState()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        bottomBar = {
            NiaButton(onClick = { /*TODO*/ }, modifier = Modifier
                .padding(start = 20.dp, end = 20.dp, bottom = 20.dp)
                .fillMaxWidth()
                .height(56.dp)
                ) {
                Text(text = "Перейти к оформлению заказа")
            }
        },


        ) {
        Column(
            Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp, bottom = 32.dp)


        ){
            Button(
                onClick = { /*TODO*/ },
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = Fon_TextFleid
                ),
                contentPadding = PaddingValues(0.dp),
                modifier = Modifier
                    .padding(top = 16.dp)
                    .width(32.dp)
                    .height(32.dp)
                    .clip(RoundedCornerShape(8.dp))
            ) {
                NiaIcon(NiaIcons.Back, content = " ")
            }
            Row(
                Modifier
                    .padding(top = 24.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                Text("Корзина", fontSize = 24.sp, fontWeight = FontWeight.Bold)
                NiaIcon(NiaIcons.Clear, content ="" )

            }
            LazyColumn(Modifier.padding(top=32.dp), userScrollEnabled = false ){

                items(5){
                    if(it<4){
                    CardKorzina()
                    }
                    else{
                        Log.d("eee","eeeeeee")
                        Row(modifier = Modifier
                            .padding(top = 40.dp, bottom = 156.dp)
                            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween){
                            Text("Cумма", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                            Text("4290 ₽", fontSize = 20.sp, fontWeight = FontWeight.Bold)
                        }
                    }
                }

            }

        }
    }
}

@Composable
fun CardKorzina(){
    Card(
        Modifier
            .padding(bottom = 16.dp)
            .fillMaxWidth()) {
        Column(
            Modifier
                .padding(16.dp)
                .fillMaxWidth()) {
            Row(Modifier.fillMaxWidth(), verticalAlignment = Alignment.Top, horizontalArrangement = Arrangement.SpaceBetween){
                Text("Клинический анализ крови с лейкоцитарной формулировкой",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(0.8f)
                    )
                Icon(androidx.compose.material.icons.Icons.Default.Clear, contentDescription ="",  )
            }
            Row(
                Modifier
                    .padding(top = 34.dp)
                    .fillMaxWidth(), verticalAlignment = Alignment.CenterVertically, horizontalArrangement = Arrangement.SpaceBetween){
                Text("690 ₽",
                    fontSize = 17.sp,
                    fontWeight = FontWeight.Bold,
                )
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Text("1 пациент",
                        fontSize = 15.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(end=16.dp)
                    )
                    Box(
                        Modifier
                            .width(64.dp)
                            .clip(RoundedCornerShape(8.dp))){
                        NiaButtonAnim(onClick = { /*TODO*/ }, modifier = Modifier
                            .width(33.dp)
                            .align(
                                Alignment.CenterStart
                            ), contentPadding = PaddingValues(0.dp)) {
                            Text("-",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,

                            )
                        }
                        NiaButtonAnim(onClick = { /*TODO*/ }, modifier = Modifier
                            .width(33.dp)
                            .align(Alignment.CenterEnd), contentPadding = PaddingValues(0.dp)) {
                            Text("+",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        Spacer(modifier = Modifier
                            .width(2.dp)
                            .height(16.dp)
                            .align(Alignment.Center)
                            .background(Color.Gray))
                    }
                }
            }
        }
    }
}