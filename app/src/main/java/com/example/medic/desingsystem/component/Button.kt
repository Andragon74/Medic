package com.example.medic.desingsystem.component

import android.util.Log
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.interaction.PressInteraction
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.RowScope
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import com.example.medic.desingsystem.theme.Aktiv_Button
import com.example.medic.desingsystem.theme.Fon_TextFleid
import com.example.medic.desingsystem.theme.No_Aktiv_Button
import com.example.medic.desingsystem.theme.Nomer_NoAktiv_Button

@Composable
fun NiaButton(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = Aktiv_Button,
            disabledBackgroundColor = No_Aktiv_Button,
            contentColor = Color.White
        ),
        contentPadding = contentPadding,
        content = content,
    )
}

@Composable
fun NiaButtonTime(
    id :Int,
    NomerButton : Int,
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
){
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = if (id==NomerButton){ Aktiv_Button } else { Fon_TextFleid },
            disabledBackgroundColor = No_Aktiv_Button,
            contentColor = if (id==NomerButton){Color.White} else {Color.Gray}
        ),
        contentPadding = contentPadding,
        content = content,
    )
}

@Composable
fun NiaButtonAnim(
    onClick: () -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    contentPadding: PaddingValues = ButtonDefaults.ContentPadding,
    content: @Composable RowScope.() -> Unit,
) {
    val intSource1 = remember { MutableInteractionSource() }
    var color1 by remember { mutableStateOf(Nomer_NoAktiv_Button) }
    Button(
        onClick = onClick,
        modifier = modifier,
        enabled = enabled,
        colors = ButtonDefaults.buttonColors(
            backgroundColor = color1,
        ),
        interactionSource = intSource1,
        contentPadding = contentPadding,
        content = content,
    )
    LaunchedEffect(Unit) {
        intSource1.interactions.collect {
            Log.d("buu",it.toString())
            color1 = when(it) {
                is PressInteraction.Press -> Aktiv_Button
                else -> Nomer_NoAktiv_Button
            }
        }
    }
}


