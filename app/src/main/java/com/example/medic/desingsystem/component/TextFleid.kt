package com.example.medic.desingsystem.component

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.TextField
import androidx.compose.material.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.example.medic.desingsystem.theme.Fon_TextFleid
import com.example.medic.desingsystem.theme.FontBorder_Aktiv
import com.example.medic.desingsystem.theme.FontBorder_NoAktiv

@Composable
fun NiaTextFleid (
    value: String,
    onValueChange: (String) -> Unit,
    modifier: Modifier = Modifier,
    enabled: Boolean = true,
    placeholder: @Composable (() -> Unit)? = null,
) {
    OutlinedTextField(
        value = value ,
        onValueChange = onValueChange ,
        modifier = modifier,
        enabled = enabled,
        placeholder =placeholder,
        colors = TextFieldDefaults.textFieldColors(
            backgroundColor = Fon_TextFleid,
            textColor = Color.Black ,
            disabledTextColor = Color.Black,
            focusedIndicatorColor = if(value== ""){FontBorder_NoAktiv}else{ FontBorder_Aktiv},
            unfocusedIndicatorColor = if(value== ""){FontBorder_NoAktiv}else{ FontBorder_Aktiv},
            disabledIndicatorColor = if(value== ""){FontBorder_NoAktiv}else{ FontBorder_Aktiv},
        ),
        singleLine = true,
        shape = RoundedCornerShape(10.dp)

    )
}