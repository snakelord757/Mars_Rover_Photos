package com.snakelord.pets.marsroverphotos.di.components

import com.snakelord.pets.marsroverphotos.di.modules.ViewModelModule
import com.snakelord.pets.marsroverphotos.presentation.MainActivity
import dagger.Component

@Component(modules = [ViewModelModule::class])
interface MainComponent {
    fun inject(main: MainActivity)
}