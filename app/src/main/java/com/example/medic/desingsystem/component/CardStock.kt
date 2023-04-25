package com.example.medic.desingsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.AsyncImage
import com.example.medic.data.NewsModel

@Composable
fun CardStock (newsModel: NewsModel) {
    Box(
        Modifier
            .padding(end = 0.dp)
            .width(270.dp)
            .height(152.dp)
            .clip(RoundedCornerShape(12.dp))
            .background(Brush.horizontalGradient(listOf(Color(0xff76B3FF), Color(0xffCDE3FF))))
    ) {

        Column(
            Modifier
                .padding(top = 16.dp, start = 16.dp, bottom = 12.dp)
                .width(170.dp)
        ) {
            Text(
                newsModel.name,
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold
            )
            Text(
                newsModel.description,
                fontSize = 12.sp,
                color = Color.White,
                modifier = Modifier
                    .height(32.dp)
                    .padding(top = 4.dp)
            )
            Text(
                "${newsModel.price} ₽",
                fontSize = 20.sp,
                color = Color.White,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(top = 4.dp)
            )
        }

        AsyncImage(
            model = newsModel.image,
            contentDescription = "",
            modifier = Modifier.fillMaxHeight().align(Alignment.BottomEnd).offset(x=35.dp),
            contentScale = ContentScale.FillHeight,
            alignment = Alignment.BottomEnd
        )

    }

}

@Composable
@Preview
fun PreviewNews(){
    CardStock(newsModel = NewsModel(name = "Чек-ап для мужчин", description = "9 исследований",id=0, price = "8000", image = "https://medic.madskill.ru/filemanager/uploads/thinking_man_PNG11598.png"))
}
