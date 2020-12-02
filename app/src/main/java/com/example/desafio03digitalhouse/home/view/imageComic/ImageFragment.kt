package com.example.desafio03digitalhouse.home.view.imageComic

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import androidx.navigation.Navigation
import com.example.desafio03digitalhouse.R
import com.squareup.picasso.Picasso


class ImageFragment : Fragment() {


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_image, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val path = arguments?.getString("path")
        val image = view.findViewById<ImageView>(R.id.imgComicAll)
        Picasso.get().load(path).into(image)

        view.findViewById<ImageView>(R.id.btnBack).setOnClickListener {
            setButtonBack(view)
        }
    }

    private fun setButtonBack(view: View){

        val navController = Navigation.findNavController(view)
        navController.navigate(R.id.action_imageFragment_to_infoComicFragment)
    }




}