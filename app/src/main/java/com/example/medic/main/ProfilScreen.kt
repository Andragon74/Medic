package com.example.medic.main

import android.annotation.SuppressLint
import android.net.Uri
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.PickVisualMediaRequest
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.layout.R
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.DropdownMenu
import androidx.compose.material.Icon
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.icons.Icons
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel
import coil.compose.rememberAsyncImagePainter
import coil.request.ImageRequest
import com.example.medic.desingsystem.component.Calendar
import com.example.medic.desingsystem.component.ComboBox
import com.example.medic.desingsystem.component.NiaButton
import com.example.medic.desingsystem.component.NiaTextFleid
import com.example.medic.desingsystem.icon.NiaIcon
import com.example.medic.desingsystem.icon.NiaIcons
import org.koin.androidx.compose.koinViewModel

class profilScreen1: Screen {

    @Composable
    override fun Content() {
        ProfilScreen(getScreenModel())
    }
}



@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun ProfilScreen (viewModel: ProfilViewModel ) {
    var photoUri: Uri? by remember {
        mutableStateOf(null)
    }

    val launcher = rememberLauncherForActivityResult(contract = ActivityResultContracts.PickVisualMedia()) { Uri ->
        photoUri = Uri
    }

    val expanded by remember { mutableStateOf(false) }


    Scaffold(
        bottomBar = {
            Row(
                Modifier
                    .padding(start = 7.dp, end = 7.dp)
                    .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceBetween ){
                Column(horizontalAlignment = Alignment.CenterHorizontally) {
                    NiaIcon(NiaIcons.Analiz, content = "")
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
        },
        modifier = Modifier.fillMaxSize(),
    ){
        Column(
            Modifier
                .fillMaxSize()
                .padding(start = 20.dp, end = 20.dp, top = 17.dp, bottom = 13.dp), horizontalAlignment = Alignment.CenterHorizontally
        ){
            Text("Карта пациента", fontSize = 24.sp, fontWeight = FontWeight.Bold)
            Box(modifier = Modifier
                .padding(top = 7.dp)
                .width(148.dp)
                .height(123.dp)
                .clip(RoundedCornerShape(60.dp))
                .background(Color.LightGray)
                .clickable {
                    launcher.launch(PickVisualMediaRequest(mediaType = ActivityResultContracts.PickVisualMedia.ImageOnly))
                },
                contentAlignment = Alignment.Center

            ){
                if(photoUri != null){
                    val painter = rememberAsyncImagePainter(
                        ImageRequest
                            .Builder(LocalContext.current)
                            .data(data = photoUri)
                            .build()
                    )
                    Image(painter = painter, contentDescription = "", contentScale = ContentScale.Crop, modifier = Modifier.fillMaxSize())
                }
                else{
                    NiaIcon(NiaIcons.Camera , content =null, modifier = Modifier
                        .width(53.dp)
                        .height(48.dp) )
                }
            }
            Text(
                "Без карты пациента вы не сможете заказать анализы.",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.LightGray,
                modifier = Modifier
                    .align(Alignment.End)
                    .fillMaxWidth()
                    .padding(top = 7.dp)
            )
            Text(
                "В картах пациентов будут храниться результаты анализов вас и ваших близких.",
                fontSize = 14.sp,
                fontWeight = FontWeight.Bold,
                color = Color.LightGray,
                modifier = Modifier
                    .align(Alignment.End)
                    .padding(top = 3.dp)
            )

            InfoUser(viewModel,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp))

            NiaButton(onClick = { /*TODO*/ }, modifier = Modifier
                .padding(top = 22.dp)
                .fillMaxWidth()
                .height(56.dp)
            ) {
                Text(text = "Сохранить")
            }



        }

    }
}
@SuppressLint("StateFlowValueCalledInComposition")
@Composable
fun InfoUser( viewModel:ProfilViewModel,modifier: Modifier=Modifier) {
    var showCalendar by remember {
        mutableStateOf(false)
    }

    val Name :String by viewModel.Name.collectAsState()
    val SurName :String by viewModel.Surname.collectAsState()
    val Otzectvo :String by viewModel.Otzectvo.collectAsState()
    val Pol :String by viewModel.Pol.collectAsState()
    val Age :String by viewModel.Age.collectAsState()

    Column(
        modifier = modifier
    ) {
        NiaTextFleid(
            value = SurName,
            onValueChange = {
                viewModel.Surname.value = it
            },

            placeholder = { Text(text = "Фамилия") },
            modifier = Modifier
                .padding(bottom = 24.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
        )
        NiaTextFleid(
            value = Name,
            onValueChange = {
                viewModel.Name.value = it
            },
            placeholder = { Text(text = "Имя") },
            modifier = Modifier
                .padding(bottom = 24.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
        )
        NiaTextFleid(
            value = Otzectvo,
            onValueChange = {
                viewModel.Otzectvo.value = it
            },
            placeholder = { Text(text = "Отчество") },
            modifier = Modifier
                .padding(bottom = 24.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
        )
        NiaTextFleid(
            value = Age,
            onValueChange = {
            },
            enabled = false,
            placeholder = { Text(text = "Дата рождения") },
            modifier = Modifier
                .padding(bottom = 24.dp)
                .fillMaxWidth()
                .clip(RoundedCornerShape(10.dp))
                .clickable { showCalendar = !showCalendar }
        )
        viewModel.Age.value = Calendar(showCalendar)
        showCalendar = false
        viewModel.Pol.value= ComboBox()
    }
}
