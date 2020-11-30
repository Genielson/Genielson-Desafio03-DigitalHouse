package com.example.desafio03digitalhouse.home.repository

import com.example.desafio03digitalhouse.home.api.NetworkUtils
import com.example.desafio03digitalhouse.home.model.ComicModel
import retrofit2.http.GET

interface ComicEndpoint {

    @GET("/v1/public/comics")

    suspend fun getComics() : List<ComicModel>

    companion object{
       val Endpoint : ComicEndpoint by lazy {
           NetworkUtils.getRetrofitInstance().create(ComicEndpoint::class.java)
       }
    }

}