package com.snakelord.pets.marsroverphotos.di.modules.photos

import com.snakelord.pets.marsroverphotos.domain.interactor.photos.PhotosInteractor
import com.snakelord.pets.marsroverphotos.domain.interactor.photos.PhotosInteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface PhotosInteractorModule {
    @Binds
    fun bindPhotosInteractor(photosInteractorImpl: PhotosInteractorImpl): PhotosInteractor
}