package com.snakelord.pets.marsroverphotos.di.modules.photos

import com.snakelord.pets.marsroverphotos.data.mapper.PhotosResponseMapper
import dagger.Module
import dagger.Provides

@Module
class PhotosMapperModule {
    @Provides
    fun bindPhotosResponseMapper(): PhotosResponseMapper = PhotosResponseMapper()
}