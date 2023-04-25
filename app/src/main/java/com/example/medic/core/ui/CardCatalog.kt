package com.example.medic.core.ui

import android.annotation.SuppressLint
import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.medic.data.CatalogModel
import com.example.medic.desingsystem.icon.NiaIcons
import com.example.medic.main.ProfilViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun CardCatalog(catalogModel: CatalogModel, onClick: () -> Unit) {

        Card(
            Modifier
                //.background(Color.Red)
                .padding(bottom = 16.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(12.dp)),
        ) {
            Column(Modifier.padding(16.dp)) {
                Text(
                    catalogModel.name,
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.fillMaxWidth(0.8f)
                )
                Row(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 16.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.SpaceBetween
                ) {
                    Column() {
                        Text(
                            catalogModel.timeResult,
                            fontSize = 14.sp,
                        )
                        Text(
                            "${catalogModel.price} ₽",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold, modifier = Modifier.padding(top = 4.dp)
                        )
                    }
                    Button(onClick = onClick, modifier = Modifier.height(40.dp)) {
                        Text(text = "Добавить", color = Color.White)

                    }
                }
            }
        }

}


@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("SuspiciousIndentation")
@Composable
fun showInfo(catalogModel: CatalogModel,sheetState: ModalBottomSheetState,coroutineScope:CoroutineScope):Boolean {
    var v by remember {
        mutableStateOf(true)
    }
    var description = catalogModel.preparation.split(".")


        Box(
            Modifier
                .padding(top = 0.dp)
                .fillMaxWidth()



        ) {
            Column(
                Modifier
                    .padding(start = 20.dp, end = 20.dp, top = 24.dp)
                    .fillMaxWidth()
            ) {
                Row(
                    Modifier.fillMaxWidth(),
                    horizontalArrangement = Arrangement.SpaceBetween,
                    verticalAlignment = Alignment.Top
                ) {
                    Text(
                        text = catalogModel.name,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.fillMaxWidth(0.76f)
                    )
                    Image(painter = painterResource(NiaIcons.Close),
                        contentDescription = "",
                        modifier = Modifier
                            .width(24.dp)
                            .height(24.dp)
                            .clickable {
                                coroutineScope.launch {
                                    sheetState.hide()
                                }
                            })

                }
                Column(
                    Modifier
                        .fillMaxWidth()
                        .padding(top = 22.dp)
                ) {
                    Column(Modifier.padding(bottom = 16.dp)) {
                        Text(
                            "Описание",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.LightGray
                        )
                        Text(
                            text =catalogModel.description ,
                            fontSize = 15.sp, modifier = Modifier.padding(top = 8.dp)
                        )
                    }
                    Column(Modifier.padding(bottom = 0.dp)) {
                        Text(
                            "Подготовка",
                            fontSize = 16.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.LightGray
                        )
                        Text(
                            text = description[0],
                            fontSize = 15.sp, modifier = Modifier.padding(top = 8.dp)
                        )
                        Text(
                            text = StringBuilder(description[1]).deleteAt(0).toString(),
                            fontSize = 15.sp, modifier = Modifier.padding(top = 8.dp)
                        )
                    }

                }
                Column(
                    Modifier
                        .padding(top = 58.dp)
                        .fillMaxWidth()
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Column() {
                            Text(
                                text = "Результаты через:",
                                fontSize = 14.sp,
                                color = Color.LightGray
                            )
                            Text(
                                catalogModel.timeResult,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,
                            )
                        }
                        Column() {
                            Text(
                                text = "Биоматериал:",
                                fontSize = 14.sp,
                                color = Color.LightGray
                            )
                            Text(
                                catalogModel.bio,
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold,

                                )
                        }
                    }
                    Button(
                        onClick = { /*TODO*/ },
                        colors = ButtonDefaults.buttonColors(
                            backgroundColor = Color.Blue,
                            contentColor = Color.White
                        ), modifier = Modifier
                            .padding(top = 19.dp, bottom=40.dp)
                            .fillMaxWidth()
                            .height(56.dp)
                    ) {
                        Text(text = "Добавить за ${catalogModel.price} ₽")
                    }
                }
            }
        }
return false
    }


@Preview
@Composable
fun PreviewCatalog(){
    CardCatalog(catalogModel = CatalogModel(
        bio ="Слизистая",
        category = "Популярные",
        description = "Клинический анализ крови – это самое важное комплексное лабораторное исследование при обследовании человека с любым заболеванием. Изменение исследуемых показателей, как правило, происходит задолго до появления видимых симптомов болезни.",
        price = "1800",
        timeResult = "2 дня",
        preparation = "Кровь следует сдавать утром натощак, днем или вечером – через 4-5 часов после последнего приема пищи. За 1–2 дня до исследования необходимо исключить из рациона продукты с высоким содержанием жиров и алкоголь.",
        id=1,
        name="ПЦР-тест на определение РНК коронавирусв стандартный"
        ), onClick = {})
}