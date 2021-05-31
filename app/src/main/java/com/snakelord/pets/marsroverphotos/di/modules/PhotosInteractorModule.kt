package com.snakelord.pets.marsroverphotos.di.modules

import com.snakelord.pets.marsroverphotos.domain.interactor.PhotosInteractor
import com.snakelord.pets.marsroverphotos.domain.interactor.PhotosInteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface PhotosInteractorModule {
    @Binds
    fun bindPhotosInteractor(photosInteractorImpl: PhotosInteractorImpl): PhotosInteractor
}