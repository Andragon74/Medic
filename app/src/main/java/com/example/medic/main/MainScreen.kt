package com.example.medic.main

import android.annotation.SuppressLint
import android.util.Log
import androidx.compose.animation.*
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.*
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cafe.adriel.voyager.core.screen.Screen
import cafe.adriel.voyager.koin.getScreenModel

import com.example.medic.core.ui.CardCatalog
import com.example.medic.core.ui.showInfo
import com.example.medic.data.CatalogModel
import com.example.medic.desingsystem.component.BottomNavigationq1
import com.example.medic.desingsystem.component.CardStock
import com.example.medic.desingsystem.theme.Fon_TextFleid
import com.example.medic.view_model.MainScreenModel
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

import org.koin.androidx.compose.koinViewModel



class mainScreen1: Screen {

    @Composable
    override fun Content() {
        MainScreen1()

    }
}





@OptIn(ExperimentalFoundationApi::class, ExperimentalAnimationApi::class,
    ExperimentalMaterialApi::class
)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
@Composable
fun MainScreen1(vm: MainScreenModel = koinViewModel() ) {
    val posts by vm.posts.collectAsState()
    val Catalog by vm.CatalogShow.collectAsState()
    val NameCatalog by vm.NameCatalog.collectAsState()
    val listState = rememberLazyListState()

    var NameButton: List<String> =
        listOf("Популярное", "Covid", "Коплексные", "Популярное", "Covid", "Коплексные")

    var visibility by remember {
        mutableStateOf(true)
    }
    var CountButton by remember {
        mutableStateOf(-1)
    }
    var poisk by remember {
        mutableStateOf("")
    }

    val sheetState = rememberModalBottomSheetState(
        initialValue = ModalBottomSheetValue.Hidden,
        confirmStateChange = { it != ModalBottomSheetValue.Expanded },
        skipHalfExpanded = true
    )
    val coroutineScope = rememberCoroutineScope()


    var selectedItem: CatalogModel? by remember {
        mutableStateOf(null)
    }

    LaunchedEffect(true){
        vm.getPost()
        vm.getPostCatalog()
    }

    ModalBottomSheetLayout(
        sheetState = sheetState,
        sheetContent = {
                if (selectedItem != null) {
                    showInfo(catalogModel = selectedItem!!,sheetState,coroutineScope)
                }
                else {
                    Text(text = "Error")
                }
        },
        modifier = Modifier.wrapContentSize(),
        sheetShape = RoundedCornerShape(24.dp, 24.dp)

    ) {

        Scaffold(
            bottomBar = {
                BottomNavigationq1()
            },
            modifier = Modifier.fillMaxSize(),


            ) {
            Column(
                Modifier
                    .fillMaxSize()
                    .padding(top = 24.dp, bottom = 56.dp)
            ) {
                TextField(
                    value = poisk,
                    onValueChange = {
                        poisk = it
                    },
                    leadingIcon = {
                        Icon(
                            androidx.compose.material.icons.Icons.Default.Search,
                            contentDescription = null
                        )
                    },
                    placeholder = { Text(text = "Искать анализы") },
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = Fon_TextFleid,
                        focusedIndicatorColor = Color.Transparent
                    ),
                    modifier = Modifier
                        .padding(start = 20.dp, end = 20.dp)
                        .fillMaxWidth()
                        .clip(RoundedCornerShape(10.dp))
                )
                AnimatedVisibility(visible = !listState.canScrollBackward) {
                    Column() {

                        Text(
                            "Акции и новости",
                            fontSize = 17.sp,
                            fontWeight = FontWeight.Bold,
                            modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 32.dp)
                        )

                        HorizontalPager(
                            pageCount = posts.size,
                            contentPadding = PaddingValues(end = 90.dp),
                            modifier = Modifier
                                .padding(top = 16.dp)
                                .height(152.dp)
                        ) {
                            CardStock(newsModel = posts[it])
                        }
                    }
                }
                AnimatedVisibility(visible = !listState.canScrollBackward) {
                    Text(
                        "Каталог анализов",
                        fontSize = 17.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(start = 20.dp, end = 20.dp, top = 32.dp)
                    )
                }
                LazyRow(
                    Modifier
                        .padding(
                            top = if (visibility) {
                                16.dp
                            } else {
                                32.dp
                            }
                        )
                        .fillMaxWidth()
                        .height(48.dp)
                ) {
                    items(NameCatalog.size) {
                        Button(
                            onClick = {
                                CountButton = it
                                vm.getSortedCatalog(NameCatalog[it])

                                Log.d("ff",NameCatalog.size.toString()) },
                            modifier = Modifier.padding(start = 16.dp),
                            colors = ButtonDefaults.buttonColors(
                                backgroundColor = if (it == CountButton) {
                                    Color.Blue
                                } else {
                                    Fon_TextFleid
                                },
                                contentColor = if (it == CountButton) {
                                    Color.White
                                } else {
                                    Color.Gray
                                }
                            )
                        ) {
                            Text(NameCatalog[it])
                        }
                    }
                }
                LazyColumn(
                    Modifier
                        .padding(start = 20.dp, end = 20.dp, top = 24.dp)
                        .fillMaxWidth(),
                    state = listState
                ) {
                    items(Catalog) { catalog ->
                        CardCatalog(catalogModel = catalog, onClick = {
                            selectedItem = catalog
                            coroutineScope.launch {
                            if (sheetState.isVisible) sheetState.hide()
                            else sheetState.show()
                        }})
                    }
                }
            }
        }
    }
}