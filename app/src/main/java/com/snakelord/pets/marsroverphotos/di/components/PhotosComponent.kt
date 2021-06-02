package com.snakelord.pets.marsroverphotos.di.components

import com.snakelord.pets.marsroverphotos.di.modules.*
import com.snakelord.pets.marsroverphotos.di.modules.photos.MarsRoverPhotosApiModule
import com.snakelord.pets.marsroverphotos.di.modules.photos.PhotosInteractorModule
import com.snakelord.pets.marsroverphotos.di.modules.photos.PhotosMapperModule
import com.snakelord.pets.marsroverphotos.di.modules.photos.ViewModelFactoryModule
import com.snakelord.pets.marsroverphotos.presentation.photos.PhotosFragment
import dagger.Component

@Component(
    modules = [
        ViewModelFactoryModule::class, OkHttpClientModule::class,
        MarsRoverPhotosApiModule::class, PhotosViewModelModule::class,
        PhotosInteractorModule::class, PhotosRepositoryModule::class, PhotosMapperModule::class]
)
interface PhotosComponent {
    fun inject(photos: PhotosFragment)
}