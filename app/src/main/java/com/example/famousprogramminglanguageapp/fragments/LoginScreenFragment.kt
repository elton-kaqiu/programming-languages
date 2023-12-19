package com.example.famousprogramminglanguageapp.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.famousprogramminglanguageapp.R
import com.example.famousprogramminglanguageapp.databinding.FragmentLoginScreenBinding


class LoginScreenFragment : Fragment() {
    private lateinit var binding: FragmentLoginScreenBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentLoginScreenBinding.inflate(inflater, container, false)
        return binding.root
    }


}