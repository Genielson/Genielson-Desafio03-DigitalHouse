package com.example.desafio03digitalhouse.home.model

data class ComicModel(
    val title:String,
    val issueNumber:Double,
    val description:String,
    val prices: Array<ComidPriceModel>,
    val dates:Array<ComicDateModel>,
    val thumbnail:Array<ImageComicModel>,
    val pageCount:Int
)