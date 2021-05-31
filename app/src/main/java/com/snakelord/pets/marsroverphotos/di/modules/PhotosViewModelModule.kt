package com.snakelord.pets.marsroverphotos.di.modules

import androidx.lifecycle.ViewModel
import com.snakelord.pets.marsroverphotos.di.annotations.ViewModelKey
import com.snakelord.pets.marsroverphotos.presentation.photos.PhotosViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface PhotosViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(PhotosViewModel::class)
    fun bindPhotosViewModel(photosViewModel: PhotosViewModel): ViewModel
}