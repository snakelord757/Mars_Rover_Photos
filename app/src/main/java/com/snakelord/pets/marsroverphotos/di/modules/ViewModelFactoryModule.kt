package com.snakelord.pets.marsroverphotos.di.modules

import androidx.lifecycle.ViewModelProvider
import com.snakelord.pets.marsroverphotos.di.ViewModelFactory
import dagger.Binds
import dagger.Module

@Module
interface ViewModelFactoryModule {
    @Binds
    fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory
}