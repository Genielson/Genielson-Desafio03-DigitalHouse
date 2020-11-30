package com.example.desafio03digitalhouse.home.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NetworkUtils {

    companion object{

        const val BASE_URL = "https://gateway.marvel.com"

        fun getRetrofitInstance() : Retrofit{
            return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        }

    }
}