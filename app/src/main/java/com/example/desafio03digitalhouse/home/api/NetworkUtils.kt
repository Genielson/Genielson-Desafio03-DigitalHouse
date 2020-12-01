package com.example.desafio03digitalhouse.home.api

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
const val MY_PUBLIC_KEY =  "5766808d99d2a3cebf435cfe2e2fd940"
const val MY_PRIVATE_KEY = "db6b0871ab2760f72fc453faf31c5ddafdab3ced"

class NetworkUtils {

    companion object{

        private const val BASE_URL = "https://gateway.marvel.com"

        fun getRetrofitInstance() : Retrofit{
            return Retrofit.Builder().baseUrl(BASE_URL).addConverterFactory(GsonConverterFactory.create()).build()
        }
    }
}