package com.example.medic.desingsystem.icon

import androidx.annotation.DrawableRes
import androidx.compose.material.Icon
import androidx.compose.material.LocalContentAlpha
import androidx.compose.material.LocalContentColor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.example.medic.R

object NiaIcons {
    val Analiz = R.drawable.icon_analiz
    val Messager = R.drawable.icon_messager
    val Result = R.drawable.icon_result
    val User = R.drawable.icon_user
    val Korzina = R.drawable.icon_korzina
    val Microfont = R.drawable.icon_microfont
    val Back=R.drawable.icon_back
    val Clear=R.drawable.icon_mycop
    val IndicatorOff = R.drawable.icon_code_no
    val IndicatorOn = R.drawable.icon_code_yes
    val Ryka = R.drawable.hello
    val BackSpase = R.drawable.icon_del
    val Camera = R.drawable.icon_camera
    val Close = R.drawable.icon_exit
    val Karta = R.drawable.icon_karta
}

sealed class  Icon{
    data class  ImageVectorIcon(val imageVector: ImageVectorIcon):Icon()
    data class  DrawableResourseIcon(@DrawableRes val id:Int):Icon()
}

@Composable
fun NiaIcon(
    painter: Int,
    content:  String?,
    modifier: Modifier = Modifier,
    tint : Color = LocalContentColor.current.copy(alpha = LocalContentAlpha.current),
){
    Icon(painter = painterResource(id = painter) , contentDescription =content, modifier = modifier,tint = tint)
}