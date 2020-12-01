package com.example.desafio03digitalhouse.home.viewmodel.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.desafio03digitalhouse.R
import com.example.desafio03digitalhouse.home.model.ComicModel
import com.squareup.picasso.Picasso

class ComicAdapter(private var quadrinhos: MutableList<ComicModel>): RecyclerView.Adapter<ComicAdapter.ItemViewHolder>() {

    class ItemViewHolder(view: View):RecyclerView.ViewHolder(view){

        private val imagem = view.findViewById<ImageView>(R.id.imgComic)
        private val numero = view.findViewById<TextView>(R.id.txtNumberComic)

        @SuppressLint("SetTextI18n")
        fun bind(quadrinho:ComicModel){

            numero.text = "# "+quadrinho.id.toString()

            Picasso.get()
                .load("${quadrinho.thumbnail.path}/portrait_uncanny.${quadrinho.thumbnail.extension}")
                .into(imagem)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_lista_comic,parent,false)

        return ItemViewHolder(view)

    }

    override fun getItemCount(): Int = quadrinhos.size

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(quadrinhos[position])
    }


}