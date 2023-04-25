package com.example.medic.view_model

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import cafe.adriel.voyager.core.model.ScreenModel
import cafe.adriel.voyager.core.model.coroutineScope
import cafe.adriel.voyager.core.registry.screenModule
import com.example.medic.data.CatalogModel
import com.example.medic.data.NewsModel
import com.example.medic.di.ApiRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.forEach
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import java.util.Locale.Category

class MainScreenModel(
    private  val apiRepository: ApiRepository
) : ViewModel() {
    val posts = MutableStateFlow<List<NewsModel>>(listOf())

    val Catalog = MutableStateFlow<List<CatalogModel>>(listOf())

    val CatalogShow = MutableStateFlow<MutableList<CatalogModel>>(mutableListOf())

    val NameCatalog  = MutableStateFlow<MutableList<String>>( mutableListOf())

    fun getNameCatalog(){

        viewModelScope.launch {
            withContext(Dispatchers.Default) {


                val categoryList = mutableListOf<String>()

                for (category in Catalog.value) {

                    categoryList.add(category.category)

                }

                NameCatalog.emit(categoryList.distinct().toMutableList())

            }
        }

    }

    fun getSortedCatalog(category: String) {
        viewModelScope.launch {
            withContext(Dispatchers.Default) {

                CatalogShow.value.clear()

                val c = mutableListOf<CatalogModel>()

                for (catalogItem in Catalog.value) {
                    if (catalogItem.category == category) c.add(catalogItem)
                }

                CatalogShow.emit(c)

            }
        }
    }

    fun getPost(){
       viewModelScope.launch {
            apiRepository.getPosts().collect{
                posts.emit(it)
            }
        }
    }

    fun getPostCatalog(){
        viewModelScope.launch {
            apiRepository.getPostsCatalog().collect(){
                Catalog.emit(it)
                CatalogShow.emit(it.toMutableList())
            }
            getNameCatalog()
        }
    }
}


