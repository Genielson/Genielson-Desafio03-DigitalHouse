package com.example.desafio03digitalhouse.home.view.informationcomic

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.observe
import androidx.navigation.Navigation
import com.example.desafio03digitalhouse.R
import com.example.desafio03digitalhouse.home.model.ComicModel
import com.example.desafio03digitalhouse.home.repository.ComicRepository
import com.example.desafio03digitalhouse.home.viewmodel.ComicViewModel
import com.squareup.picasso.Picasso


class InfoComicFragment : Fragment() {

    private lateinit var _viewModel : ComicViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_info_comic, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val idrecovery = arguments?.getInt("id")
        setButtonBack(view)

        _viewModel = ViewModelProvider(
            this,
            ComicViewModel.ComicViewModelFactory(ComicRepository())
        ).get(ComicViewModel::class.java)

        if (idrecovery != null) {
            _viewModel.getUniqueComic(idrecovery).observe(viewLifecycleOwner) {
                exibirDados(view,it)
            }
        }
    }

    private fun setButtonBack(view:View){

        val buttonBack = view.findViewById<ImageView>(R.id.btnBack)

        buttonBack.setOnClickListener {

            val navController = Navigation.findNavController(view)
            navController.navigate(R.id.action_infoComicFragment_to_homeFragment)
        }
    }

    private fun exibirDados(view:View,item: ComicModel){

        val titulo = view.findViewById<TextView>(R.id.txtTitleComic)
        val description = view.findViewById<TextView>(R.id.txtDescriptionComic)
        val published = view.findViewById<TextView>(R.id.txtDatePublishedComic)
        val price = view.findViewById<TextView>(R.id.txtPriceComic)
        val count = view.findViewById<TextView>(R.id.txtComicCount)
        val image = view.findViewById<ImageView>(R.id.imgThumbnail)
        val background = view.findViewById<ImageView>(R.id.imgBackgroundComic)
        val formatDate = item.dates[0].date.split("T")
        val completePathExtension = "${item.thumbnail.path}/portrait_uncanny.${item.thumbnail.extension}"
        val completePathExtensionBackground = "${item.thumbnail.path}/portrait_uncanny.${item.thumbnail.extension}"

        titulo.text = item.title
        description.text = item.description
        published.text = formatDate[0]
        price.text = "$ ${item.prices[0].price}"
        count.text = item.pageCount.toString()


        Picasso.get()
            .load(completePathExtension)
            .into(image)

        Picasso.get()
            .load(completePathExtensionBackground).
             fit().
             centerCrop()
            .into(background)

        image.setOnClickListener {
            mostrarImagemComic(it,completePathExtension,item.id)
        }
    }

    private fun mostrarImagemComic(view:View, path:String, id:Int){

        val bundle = bundleOf("path" to path, "id" to id)

        val navController = Navigation.findNavController(view)
        navController.navigate(R.id.action_infoComicFragment_to_imageFragment,bundle)
    }

}