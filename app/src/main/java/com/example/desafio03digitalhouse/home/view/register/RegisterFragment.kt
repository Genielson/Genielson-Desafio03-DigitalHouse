package com.example.desafio03digitalhouse.home.view.register

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.ImageView
import androidx.navigation.Navigation
import com.example.desafio03digitalhouse.R
import com.google.android.material.textfield.TextInputEditText
import com.google.android.material.textfield.TextInputLayout


class RegisterFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_register, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        view.findViewById<ImageView>(R.id.imgReturn).setOnClickListener {

                val navController = Navigation.findNavController(view)
                navController.navigate(R.id.action_registerFragment_to_loginFragment)
        }

        view.findViewById<Button>(R.id.containedButtonLogin).setOnClickListener {

            if(validaDadosRegister(view)) {
                val navController = Navigation.findNavController(view)
                navController.navigate(R.id.action_registerFragment_to_homeFragment)
            }

        }

    }

    private fun validaDadosRegister(view:View):Boolean{

        val name = view.findViewById<TextInputEditText>(R.id.txtFieldNameRegisterContent)

        val email = view.findViewById<TextInputEditText>(R.id.txtFieldEmailRegisterContent)

        val password = view.findViewById<TextInputEditText>(R.id.txtFieldPasswordRegisterContent)

        var resultado = true

        if(name.text?.isBlank()!!){
            view.findViewById<TextInputLayout>(R.id.txtFieldNameRegister).error = getString(R.string.empty_name)
            resultado = false
        }

        if(email.text?.isBlank()!!){
            view.findViewById<TextInputLayout>(R.id.txtFieldEmailRegister).error = getString(R.string.empty_email)
            resultado = false
        }

        if(password.text?.isBlank()!!){
            view.findViewById<TextInputLayout>(R.id.txtFieldPasswordRegister).error = getString(R.string.empty_password)
            resultado = false
        }

        return resultado
    }

}