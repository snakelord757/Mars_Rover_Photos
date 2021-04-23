package com.snakelord.pets.marsroverphotos.di.components

import com.snakelord.pets.marsroverphotos.di.modules.MarsRoverPhotosApiModule
import com.snakelord.pets.marsroverphotos.di.modules.OkHttpClientModule
import com.snakelord.pets.marsroverphotos.di.modules.ViewModelModule
import com.snakelord.pets.marsroverphotos.presentation.MainActivity
import dagger.Component

@Component(modules = [ViewModelModule::class, MarsRoverPhotosApiModule::class,
            OkHttpClientModule::class])
interface MainComponent {
    fun inject(main: MainActivity)
}