package com.example.desafio03digitalhouse.home.view.informationcomic

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
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

        val idrecovery = arguments?.getString("id")!!.toInt()

        setButtonBack(view)

        _viewModel = ViewModelProvider(
            this,
            ComicViewModel.ComicViewModelFactory(ComicRepository())
        ).get(ComicViewModel::class.java)

        _viewModel.getUniqueComic(idrecovery).observe(viewLifecycleOwner) {
            exibirDados(view,it)
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
        val image = view.findViewById<ImageButton>(R.id.imgThumbnail)
        val background = view.findViewById<ImageView>(R.id.imgBackgroundComic)

        titulo.text = item.title
        description.text = item.description
        published.text = item.dates[0].date
        price.text = item.prices[0].price.toString()
        count.text = item.pageCount.toString()

        Picasso.get()
            .load("${item.thumbnail.path}/portrait_uncanny.${item.thumbnail.extension}")
            .into(image)

        Picasso.get()
            .load("${item.images[0].path}/portrait_uncanny.${item.images[0].extension}")
            .into(background)
    }

}