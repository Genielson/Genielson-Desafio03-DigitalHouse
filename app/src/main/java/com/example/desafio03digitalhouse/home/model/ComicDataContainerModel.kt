package com.example.desafio03digitalhouse.home.model

import androidx.annotation.Keep

@Keep
data class ComicDataContainerModel(
    val results: List<ComicModel>,
    val offset: Int,
    val limit: Int,
    val total: Int,
    val count: Int

)
