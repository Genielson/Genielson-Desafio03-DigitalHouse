package com.example.desafio03digitalhouse.home.repository


import com.example.desafio03digitalhouse.home.api.MY_PUBLIC_KEY
import com.example.desafio03digitalhouse.home.api.getHash
import com.example.desafio03digitalhouse.home.api.getTimeStamp

class ComicRepository {

    private val comic = ComicEndpoint.Endpoint

    suspend fun getComics() = comic.getComics("comic",
        "comic",
        true,
        getTimeStamp(),
        getHash(),
        MY_PUBLIC_KEY)


    suspend fun getUniqueComic(id:Int) = comic.getUniqueComic(id,"comic",
        "comic",
        true,
        getTimeStamp(),
        getHash(),
        MY_PUBLIC_KEY)


}