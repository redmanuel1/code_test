package com.example.beerlistview.api

import com.example.beerlistview.model.Beer
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface APIService {
    @GET("beers")
    suspend fun getBeers() : List<Beer>

    companion object{
        var apiService: APIService? = null
        fun getInstance(): APIService {
            if(apiService == null) {
                apiService = Retrofit.Builder()
                    .baseUrl("https://api.punkapi.com/v2/")
                    .addConverterFactory(GsonConverterFactory.create())
                    .build().create(APIService::class.java)
            }
            return apiService!!;
        }
    }
}