package com.example.medic.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import com.example.medic.data.MessageDTO
import com.example.medic.di.ApiRepository
import com.example.medic.di.ResultWrapper
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import okhttp3.Dispatcher

class AuthorizationScreenModel(
    private  val apiRepository: ApiRepository
    ) : ViewModel()
{


        val email = MutableStateFlow<String>("")
        val code = MutableStateFlow("")
        val ErrorCode = MutableStateFlow(false)

        val timer = MutableStateFlow(0)

        fun getCode() {

            if (timer.value == 0) {
                viewModelScope.launch {
                    apiRepository.sendCode(email.value)

                }
            }

        }

    suspend fun startTimer() {
        timer.value = 60

        while (timer.value != 0) {
            delay(1000)
            timer.value -= 1
        }

    }

        fun postCode(){
            viewModelScope.launch {
                var Token = apiRepository.signIn(email.value,code.value).toString()
               Log.d("fff",Token)
                if(Token == "GenericError(error=Оибка в логине или пароле.)"){
                   ErrorCode.value=true
                    Log.d("fff","dsdsds")
               }
                else{
                    Log.d("fff","dsds44ds")
                    ErrorCode.value = false
               }

            }
        }





    }