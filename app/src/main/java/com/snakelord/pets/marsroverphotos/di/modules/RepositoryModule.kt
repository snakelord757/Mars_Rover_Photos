package com.snakelord.pets.marsroverphotos.di.modules

import com.snakelord.pets.marsroverphotos.data.repositories.PhotosRepository
import com.snakelord.pets.marsroverphotos.data.repositories.PhotosRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RepositoryModule {
    @Binds
    fun bindPhotosRepository(photosRepositoryImpl: PhotosRepositoryImpl): PhotosRepository
}