package com.snakelord.pets.marsroverphotos.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import com.snakelord.pets.marsroverphotos.R
import com.snakelord.pets.marsroverphotos.di.components.DaggerMainComponent
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject lateinit var factory: ViewModelProvider.Factory
    private lateinit var mainViewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        DaggerMainComponent
            .create()
            .inject(this)
        mainViewModel = ViewModelProvider(this, factory)[MainViewModel::class.java]
    }

}