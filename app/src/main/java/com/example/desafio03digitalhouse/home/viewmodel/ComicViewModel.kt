package com.example.desafio03digitalhouse.home.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.liveData
import com.example.desafio03digitalhouse.home.model.ComicModel
import com.example.desafio03digitalhouse.home.repository.ComicRepository
import kotlinx.coroutines.Dispatchers

class ComicViewModel(private val repository: ComicRepository):ViewModel() {

     private var quadrinhos : List<ComicModel> = listOf()

     fun getComics() = liveData(Dispatchers.IO){
        try {
            val response = repository.getComics()

            quadrinhos = response.data.results
            emit(quadrinhos)

        }catch(ex:Exception){
            println("Erro : "+ex.message)
        }

    }

    class ComicViewModelFactory(private val repository: ComicRepository): ViewModelProvider.Factory {
        override fun <T : ViewModel?> create(modelClass: Class<T>): T {
            return ComicViewModel(repository) as T
        }
    }

}