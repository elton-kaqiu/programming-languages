package com.example.famousprogramminglanguageapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.famousprogramminglanguageapp.R
import com.example.famousprogramminglanguageapp.databinding.FragmentLoginScreenBinding
import com.example.famousprogramminglanguageapp.models.User


class LoginScreenFragment : Fragment() {
    private lateinit var binding: FragmentLoginScreenBinding
    private val list = listOf(
        User("totty", "kerkahskokna"),
        User("bleter", "ezz-vs-shqipdoni"),
        User("annihilation", "80%hs"),
        User("babaQer", "spokap"),
        User("leoon", "baiter")
    )

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnLogin.setOnClickListener {
            val setUsername = binding.username.text.toString()
            val setPassword = binding.password.text.toString()
            validateCredentials(setUsername, setPassword)
        }
        binding.forgotPassword.setOnClickListener {
            val enteredUsername = binding.username.text.toString()
            handlePassword(enteredUsername)
        }
    }

    private fun handlePassword(enteredUsername: String) {
        val user = list.find { (it.username == enteredUsername) }
        if (user != null) {
            Toast.makeText(
                requireContext(),
                "Ky eshte passwordi juaj: ${user.password}",
                Toast.LENGTH_LONG
            ).show()
        } else {
            Toast.makeText(
                requireContext(),
                "Nuk egziston useri me keto te dhena",
                Toast.LENGTH_LONG
            ).show()
        }

    }


    private fun validateCredentials(username: String, password: String) {
        val user = list.find { (it.username == username) && (it.password == password) }
        if (user != null) {
            parentFragmentManager.beginTransaction().apply {
                replace(R.id.fragmentContainer, LoginScreenFragment())
                addToBackStack("")
                commit()
            }
        } else {
            Toast.makeText(requireContext(), "Gabim username/password", Toast.LENGTH_LONG).show()
        }
    }


}



