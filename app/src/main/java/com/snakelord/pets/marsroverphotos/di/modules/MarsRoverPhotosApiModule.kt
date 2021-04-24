package com.snakelord.pets.marsroverphotos.di.modules

import com.snakelord.pets.marsroverphotos.data.network.MarsRoverPhotosApi
import com.snakelord.pets.marsroverphotos.data.network.MarsRoverPhotosApiImpl
import dagger.Binds
import dagger.Module

@Module
interface MarsRoverPhotosApiModule {
    @Binds
    fun bindMarsRoverPhotosApi(marsRoverPhotosApiImpl: MarsRoverPhotosApiImpl): MarsRoverPhotosApi
}