package com.example.desafio03digitalhouse.home.model

import androidx.annotation.Keep

@Keep
    data class ComicDataWrapperModel(
    val code: Int,
    val status: String,
    val copyright: String,
    val attributionText: String,
    val attributionHtml: String,
    val data: ComicDataContainerModel,
    val etag: String
    )

