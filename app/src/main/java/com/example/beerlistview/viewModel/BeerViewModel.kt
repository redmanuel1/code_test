package com.example.beerlistview.viewModel


import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope

import com.example.beerlistview.api.APIService
import com.example.beerlistview.model.Beer
import kotlinx.coroutines.launch
import java.lang.Exception

class BeerViewModel: ViewModel (){
    var beerListResponse: List<Beer> by mutableStateOf(listOf())
    var errorMessage: String by mutableStateOf("");

    fun getBeerList() {
        viewModelScope.launch {
            val apiService = APIService.getInstance();
            try {
                val beerList = apiService.getBeers();
                beerListResponse = beerList;
            }catch (e:Exception){
                errorMessage = e.message.toString();
            }
        }
    }
}