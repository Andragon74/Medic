package com.example.medic.desingsystem.component

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Switch
import androidx.compose.material.SwitchDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.*
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.medic.desingsystem.theme.SwitchFalseBackround
import com.example.medic.desingsystem.theme.SwitchTrueBackround

@Composable
fun SwitchBox(
    checked: Boolean,
    modifier: Modifier =Modifier,
):Boolean {
    var checked1 by remember {
        mutableStateOf(checked)
    }
    Box(modifier = modifier
        .clip( RoundedCornerShape(20.dp) )
        .background(
            if (checked1 == false) {
                SwitchFalseBackround
            } else {
                SwitchTrueBackround
            }
        )

    ) {

        Switch(
            checked = checked1,
            onCheckedChange = {checked1 = it},
            modifier = Modifier.fillMaxSize(),
            colors = SwitchDefaults.colors(
                checkedThumbColor = Color.White,
                checkedTrackColor = SwitchTrueBackround,
                uncheckedTrackColor = SwitchFalseBackround
                )


            )

    }
    return checked1
}