package com.example.desafio03digitalhouse.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.desafio03digitalhouse.home.model.ComicModel
import com.example.desafio03digitalhouse.home.repository.ComicRepository
import kotlinx.coroutines.Dispatchers

class ComicViewModel(private val repository: ComicRepository):ViewModel() {

     private var quadrinhos : List<ComicModel> = listOf()
     private lateinit var quadrinhoUnico : ComicModel

     fun getComics() = liveData(Dispatchers.IO){
        try {
            val response = repository.getComics()

            quadrinhos = response.data.results
            emit(quadrinhos)

        }catch(e:Exception){
            println("Erro : ${e.message} ")
        }

    }

    fun getUniqueComic(id:Int) = liveData(Dispatchers.IO) {

        try{

            var response = repository.getUniqueComic(id)

            quadrinhoUnico = response.data.results[0]

            emit(quadrinhoUnico)
            
        }catch (e:Exception){
            println("Erro : ${e.message}")
        }

    }

    class ComicViewModelFactory(private val repository: ComicRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ComicViewModel(repository) as T
        }
    }

}