package com.example.medic.desingsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.medic.desingsystem.icon.Icon
import com.example.medic.desingsystem.icon.NiaIcon
import com.example.medic.desingsystem.icon.NiaIcons
import com.example.medic.desingsystem.theme.Fon_TextFleid
import com.example.medic.desingsystem.theme.FontBorder_Aktiv
import com.example.medic.desingsystem.theme.FontBorder_NoAktiv

@Composable
fun ComboBox(Pol:String=""):String{
    var expanded by remember { mutableStateOf(false) }
    var value by remember {
        mutableStateOf(Pol)
    }
    Box(
        Modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .border(
                1.dp, if (value == "") {
                    FontBorder_NoAktiv
                } else {
                    FontBorder_Aktiv
                }, RoundedCornerShape(10.dp)
            )
            .background(Fon_TextFleid)

    ){
        Row(
            Modifier
                .padding(14.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
            Text(value, fontSize = 16.sp)
            NiaIcon(NiaIcons.Back, content = null, modifier = Modifier
                .rotate(-90f)
                .clickable { expanded = !expanded } )
        }
        DropdownMenu(
            modifier = Modifier.fillMaxWidth(),
            expanded = expanded,
            onDismissRequest = { expanded = false }
        ) {
            Text(
                "Мужской",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .clickable(onClick = {
                        value = "Мужской"
                        expanded = false
                    })
            )
            Text(
                "Женский",
                fontSize = 18.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier
                    .padding(10.dp)
                    .fillMaxWidth()
                    .clickable(onClick = {
                        value = "Женский"
                        expanded = false
                    })
            )

        }
    }
    return value
}
@Composable
fun DataComboBox(modifier: Modifier=Modifier):String{
    var Data by remember {
        mutableStateOf("")
    }
    var showCalendar by remember {
        mutableStateOf(false)
    }
    Box(
        modifier
            .fillMaxWidth()
            .clip(RoundedCornerShape(10.dp))
            .border(
                1.dp, if (Data == "") {
                    FontBorder_NoAktiv
                } else {
                    FontBorder_Aktiv
                }, RoundedCornerShape(10.dp)
            )
            .background(Fon_TextFleid)

    ){
        Row(
            Modifier
                .padding(14.dp)
                .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween, verticalAlignment = Alignment.CenterVertically){
            Text(Data, fontSize = 16.sp)
            NiaIcon(NiaIcons.Back, content = null, modifier = Modifier
                .rotate(-90f)
                .clickable { showCalendar = !showCalendar } )
        }
        Data=Calendar(show =showCalendar )
        showCalendar=false
        }
    return Data
}
@Preview
@Composable
fun PreviewBut() {
    ComboBox()
}