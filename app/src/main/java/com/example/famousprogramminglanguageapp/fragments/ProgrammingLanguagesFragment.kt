package com.example.famousprogramminglanguageapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.example.famousprogramminglanguageapp.R
import com.example.famousprogramminglanguageapp.adapters.ProgrammingLanguageAdapter
import com.example.famousprogramminglanguageapp.databinding.FragmentProgrammingLanguagesBinding
import com.example.famousprogramminglanguageapp.models.ProgrammingLanguages
import com.google.android.material.snackbar.Snackbar
import java.util.Date

class ProgrammingLanguagesFragment : Fragment() {
    private lateinit var binding: FragmentProgrammingLanguagesBinding
    private val list = listOf(
        ProgrammingLanguages("Java", "23/05/1995", 20),
        ProgrammingLanguages("Kotlin", "20/07/2011", 10),
        ProgrammingLanguages("Python", "20/02/1991", 30),
        ProgrammingLanguages("JavaScript", "04/12/1995", 15),
        ProgrammingLanguages("C++", "01/01/1983", 12),
        ProgrammingLanguages("Swift", "02/06/2014", 5),
        ProgrammingLanguages("C#", "20/07/2000", 8),
        ProgrammingLanguages("Ruby", "21/12/1995", 3),
        ProgrammingLanguages("Go", "10/11/2009", 2),
        ProgrammingLanguages("Rust", "07/07/2010", 1),
        ProgrammingLanguages("TypeScript", "01/10/2012", 7),
        ProgrammingLanguages("PHP", "08/06/1995", 18),
        ProgrammingLanguages("C", "02/04/1972", 25),
        ProgrammingLanguages("R", "15/08/1993", 6),
        ProgrammingLanguages("Haskell", "01/12/1990", 1),
        ProgrammingLanguages("Objective-C", "01/03/1984", 4)
    )

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProgrammingLanguagesBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val langAdapter = ProgrammingLanguageAdapter(requireContext(), list)
        binding.programmingLanguagesList.adapter = langAdapter

        binding.programmingLanguagesList.setOnItemClickListener { parent, view, position, id ->
            val selectedProgramingLanguage = langAdapter.getItem(position) as ProgrammingLanguages
            showSnackBar("Kjo gjuhe quhet: ${selectedProgramingLanguage.languageName} dhe daton prej: ${selectedProgramingLanguage.createdDate}")
        }
    }

    private fun showSnackBar(message: String) {
        Snackbar.make(requireView(), message, Snackbar.LENGTH_LONG).show()
    }

}