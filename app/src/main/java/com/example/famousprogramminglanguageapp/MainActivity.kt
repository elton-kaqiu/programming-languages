package com.example.famousprogramminglanguageapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.famousprogramminglanguageapp.databinding.ActivityMainBinding
import com.example.famousprogramminglanguageapp.fragments.ProgrammingLanguagesFragment
import com.example.famousprogramminglanguageapp.fragments.LoginScreenFragment as LoginScreenFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val loginScreenFragment = LoginScreenFragment()
        setFragment(loginScreenFragment)
    }

    private fun setFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction().apply {
            replace(R.id.fragmentContainer, fragment)
            addToBackStack(null)
            commit()
        }
    }

}