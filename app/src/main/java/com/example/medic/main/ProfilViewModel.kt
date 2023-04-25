package com.example.medic.main

import androidx.lifecycle.ViewModel
import cafe.adriel.voyager.core.model.ScreenModel
import kotlinx.coroutines.flow.MutableStateFlow

class ProfilViewModel: ViewModel() {
    val Surname: MutableStateFlow<String> = MutableStateFlow("")

    val Name: MutableStateFlow<String> = MutableStateFlow("")

    val Otzectvo: MutableStateFlow<String> = MutableStateFlow("")

    val Age: MutableStateFlow<String> = MutableStateFlow("")
    val Pol: MutableStateFlow<String> = MutableStateFlow("")
}