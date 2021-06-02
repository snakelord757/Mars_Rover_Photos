package com.snakelord.pets.marsroverphotos.di.components

import com.snakelord.pets.marsroverphotos.di.modules.OkHttpClientModule
import com.snakelord.pets.marsroverphotos.di.modules.ViewModelFactoryModule
import com.snakelord.pets.marsroverphotos.di.modules.photos.*
import com.snakelord.pets.marsroverphotos.presentation.photos.PhotosFragment
import dagger.Component

@Component(
    modules = [
        MarsRoverPhotosApiModule::class, PhotosViewModelModule::class,
        PhotosInteractorModule::class, PhotosRepositoryModule::class,
        PhotosMapperModule::class, ViewModelFactoryModule::class,
        OkHttpClientModule::class,]
)
interface PhotosComponent {
    fun inject(photos: PhotosFragment)
}