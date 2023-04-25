package com.example.medic.core.ui

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Clear
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medic.desingsystem.component.NiaButtonAnim

@Composable
fun CardKorzina() {
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
                Icon(Icons.Default.Clear, contentDescription ="",  )
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
                            ), contentPadding = PaddingValues(0.dp)
                        ) {
                            Text("-",
                                fontSize = 15.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                        NiaButtonAnim(onClick = { /*TODO*/ }, modifier = Modifier
                            .width(33.dp)
                            .align(Alignment.CenterEnd), contentPadding = PaddingValues(0.dp)
                        ) {
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


@Preview
@Composable
fun PreviewCard(){
    CardKorzina()
}