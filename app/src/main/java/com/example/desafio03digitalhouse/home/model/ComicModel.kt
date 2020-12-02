package com.example.desafio03digitalhouse.home.model

data class ComicModel(
    val id:Int,
    val title:String,
    val issueNumber:Double,
    val description:String,
    val prices:Array<ComicPriceModel>,
    val dates:Array<ComicDateModel>,
    val images:Array<ImageModel>,
    val thumbnail:ImageModel,
    val pageCount:Int
)