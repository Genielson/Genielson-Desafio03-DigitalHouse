package com.example.desafio03digitalhouse.home.view.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation
import com.example.desafio03digitalhouse.R
import com.google.android.material.textfield.TextInputEditText


class LoginFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_login, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val navController = Navigation.findNavController(view)

        view.findViewById<Button>(R.id.containedButtonLogin).setOnClickListener {
            if(validaDadosLogin(view)) {
                navController.navigate(R.id.action_loginFragment_to_homeFragment)
            }
        }

        view.findViewById<Button>(R.id.containedButtonRegister).setOnClickListener {
                navController.navigate(R.id.action_loginFragment_to_registerFragment)
        }

    }

    private fun validaDadosLogin(view:View):Boolean{

        val email = view.findViewById<TextInputEditText>(R.id.txtFieldEmailLoginContent)
        val password = view.findViewById<TextInputEditText>(R.id.txtFieldPasswordLoginContent)
         var resultado = true

        if(email.text?.isBlank()!!){
            email.error = getString(R.string.empty_email)
            resultado = false
        }

        if(password.text?.isBlank()!!){
            password.error = getString(R.string.empty_password)
            resultado = false
        }

        return resultado
    }

}