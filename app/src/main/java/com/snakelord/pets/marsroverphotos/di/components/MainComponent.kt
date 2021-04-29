package com.snakelord.pets.marsroverphotos.di.components

import com.snakelord.pets.marsroverphotos.di.modules.*
import com.snakelord.pets.marsroverphotos.presentation.main.MainActivity
import dagger.Component

@Component(modules = [ViewModelModule::class, MarsRoverPhotosApiModule::class,
            OkHttpClientModule::class, InteractorModule::class,
            RepositoryModule::class, MapperModule::class])
interface MainComponent {
    fun inject(main: MainActivity)
}