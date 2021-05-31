package com.snakelord.pets.marsroverphotos.di.components

import com.snakelord.pets.marsroverphotos.di.modules.*
import com.snakelord.pets.marsroverphotos.presentation.main.MainActivity
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