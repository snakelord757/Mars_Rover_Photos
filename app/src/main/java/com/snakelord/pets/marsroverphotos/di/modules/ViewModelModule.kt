package com.snakelord.pets.marsroverphotos.di.modules

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.snakelord.pets.marsroverphotos.di.ViewModelFactory
import com.snakelord.pets.marsroverphotos.di.annotations.ViewModelKey
import com.snakelord.pets.marsroverphotos.presentation.MainViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface ViewModelModule {
    @Binds
    fun provideViewModelFactory(factory: ViewModelFactory): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(MainViewModel::class)
    fun bindMainViewModel(mainViewModel: MainViewModel): ViewModel
}