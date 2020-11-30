package com.example.desafio03digitalhouse.home.repository

class ComicRepository {

    val client = ComicEndpoint.Endpoint

    suspend fun getComics() = client.getComics()

}