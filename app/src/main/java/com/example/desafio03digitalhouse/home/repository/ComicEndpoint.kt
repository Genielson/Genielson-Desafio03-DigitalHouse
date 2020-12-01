package com.example.desafio03digitalhouse.home.repository
import com.example.desafio03digitalhouse.home.api.NetworkUtils
import com.example.desafio03digitalhouse.home.model.ComicDataWrapperModel
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ComicEndpoint {

    @GET("/v1/public/comics")
    suspend fun getComics(
        @Query("format") format: String?,
        @Query("formatType") formatType: String?,
        @Query("noVariants") noVariants: Boolean,
        @Query("ts") ts: String?,
        @Query("hash") hash: String?,
        @Query("apikey") apikey: String?
    ) : ComicDataWrapperModel

    @GET("/v1/public/comics/{id}")
    suspend fun getUniqueComic(
        @Path("id") id:Int,
        @Query("format") format: String?,
        @Query("formatType") formatType: String?,
        @Query("noVariants") noVariants: Boolean,
        @Query("ts") ts: String?,
        @Query("hash") hash: String?,
        @Query("apikey") apikey: String?
    ) : ComicDataWrapperModel


    companion object{
       val Endpoint : ComicEndpoint by lazy {
           NetworkUtils.getRetrofitInstance().create(ComicEndpoint::class.java)
       }
    }

}