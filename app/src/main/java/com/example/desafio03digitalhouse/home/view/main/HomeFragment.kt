package com.example.desafio03digitalhouse.home.view.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio03digitalhouse.R
import com.example.desafio03digitalhouse.home.model.ComicModel
import com.example.desafio03digitalhouse.home.repository.ComicRepository
import com.example.desafio03digitalhouse.home.viewmodel.ComicViewModel
import com.example.desafio03digitalhouse.home.viewmodel.adapter.ComicAdapter

class HomeFragment : Fragment() {

    private lateinit var viewModel : ComicViewModel
    private lateinit var myadapter  : ComicAdapter

    private var listaPersonagem = mutableListOf<ComicModel>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        setupRecyclerView(view)

    }

    private fun setupRecyclerView(view: View){

        val recyclerView = view.findViewById<RecyclerView>(R.id.recyclerView)

        val manager = GridLayoutManager(view.context,3)

        listaPersonagem = mutableListOf()

        myadapter = ComicAdapter(listaPersonagem)

        recyclerView.apply{
            setHasFixedSize(true)
            layoutManager = manager
            adapter = myadapter
        }


        viewModel = ViewModelProvider(
            this,
            ComicViewModel.ComicViewModelFactory(ComicRepository())
        ).get(ComicViewModel::class.java)

        viewModel.getComics().observe(viewLifecycleOwner) {
            exibirResultados(it)
        }


    }

    private fun exibirResultados(lista: List<ComicModel>) {

        lista.let { listaPersonagem.addAll(it) }
        myadapter.notifyDataSetChanged()

    }


}