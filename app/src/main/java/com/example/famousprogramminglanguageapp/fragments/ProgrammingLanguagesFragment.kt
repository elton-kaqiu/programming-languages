package com.example.famousprogramminglanguageapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.famousprogramminglanguageapp.R
import com.example.famousprogramminglanguageapp.adapters.ProgrammingLanguageAdapter
import com.example.famousprogramminglanguageapp.databinding.FragmentProgrammingLanguagesBinding
import com.example.famousprogramminglanguageapp.models.ProgrammingLanguages
import java.util.Date

class ProgrammingLanguagesFragment : Fragment() {
    private lateinit var binding: FragmentProgrammingLanguagesBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentProgrammingLanguagesBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val list = listOf(
            ProgrammingLanguages("Java", Date(1995, 5, 23), 20),
            ProgrammingLanguages("Kotlin", Date(2011, 7, 20), 10),
            ProgrammingLanguages("Python", Date(1991, 2, 20), 30),
            ProgrammingLanguages("JavaScript", Date(1995, 12, 4), 15),
            ProgrammingLanguages("C++", Date(1983, 1, 1), 12),
            ProgrammingLanguages("Swift", Date(2014, 6, 2), 5),
            ProgrammingLanguages("C#", Date(2000, 7, 20), 8),
            ProgrammingLanguages("Ruby", Date(1995, 12, 21), 3),
            ProgrammingLanguages("Go", Date(2009, 11, 10), 2),
            ProgrammingLanguages("Rust", Date(2010, 7, 7), 1)
        )
        val progLangAdapter = ProgrammingLanguageAdapter(requireContext(), list)
        binding.programmingLanguagesList.adapter = progLangAdapter
    }
}