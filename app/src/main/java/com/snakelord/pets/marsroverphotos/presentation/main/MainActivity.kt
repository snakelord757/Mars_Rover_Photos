package com.snakelord.pets.marsroverphotos.presentation.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.NavigationUI
import com.snakelord.pets.marsroverphotos.R
import com.snakelord.pets.marsroverphotos.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private var mainActivityBinding: ActivityMainBinding? = null
    private val binding
        get() = mainActivityBinding!!
    private val navController by lazy { initNavController() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainActivityBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        NavigationUI.setupWithNavController(binding.bottomNavigationView, navController)
    }

    private fun initNavController(): NavController {
        return (supportFragmentManager
            .findFragmentById(R.id.fragmentContainer) as NavHostFragment)
            .navController
    }

}