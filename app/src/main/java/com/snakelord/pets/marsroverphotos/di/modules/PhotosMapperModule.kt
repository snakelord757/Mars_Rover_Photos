package com.snakelord.pets.marsroverphotos.di.modules

import com.snakelord.pets.marsroverphotos.domain.mapper.PhotosResponseMapper
import dagger.Module
import dagger.Provides

@Module
class PhotosMapperModule {
    @Provides
    fun bindPhotosResponseMapper(): PhotosResponseMapper = PhotosResponseMapper()
}