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
            val enteredUsername = binding.username.text.toString()
            val enteredPassword = binding.password.text.toString()
            validateCredentials(enteredUsername, enteredPassword)
        }
        binding.forgotPassword.setOnClickListener {
            val enteredUsername = binding.username.text.toString()
            handlePassword(enteredUsername)
        }
    }

    private fun validateCredentials(enteredUsername: String, enteredPassword: String) {
        val user =
            list.find { (it.username == enteredUsername) && (it.password == enteredPassword) }
        val programmingLanguagesFragment = ProgrammingLanguagesFragment()
        //user?.let{block} checks if user is not null than let {block} is executed, ?: this is the else part if user is null
        user?.let { setFragment(programmingLanguagesFragment) }
            ?: showToast("Gabim username/password")
    }

    private fun handlePassword(enteredUsername: String) {
        val user = list.find { (it.username == enteredUsername) }
        user?.let { showToast("Ky eshte passwordi juaj: ${user.password}") }
            ?: showToast("Nuk egziston useri me keto te dhena")

    }

    private fun setFragment(fragment: Fragment) {
        parentFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, ProgrammingLanguagesFragment())
            addToBackStack(null)
            commit()
        }
    }

    private fun showToast(message: String) {
        Toast.makeText(requireContext(), message, Toast.LENGTH_LONG).show()
    }
}



