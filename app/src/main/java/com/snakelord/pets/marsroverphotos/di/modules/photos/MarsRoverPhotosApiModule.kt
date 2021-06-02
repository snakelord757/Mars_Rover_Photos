package com.snakelord.pets.marsroverphotos.di.modules.photos

import com.snakelord.pets.marsroverphotos.data.network.api.photos.MarsRoverPhotosApi
import com.snakelord.pets.marsroverphotos.data.network.api.photos.MarsRoverPhotosApiImpl
import dagger.Binds
import dagger.Module

@Module
interface MarsRoverPhotosApiModule {
    @Binds
    fun bindMarsRoverPhotosApi(marsRoverPhotosApiImpl: MarsRoverPhotosApiImpl): MarsRoverPhotosApi
}