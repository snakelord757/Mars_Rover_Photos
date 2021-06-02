package com.snakelord.pets.marsroverphotos.di.modules.rovers

import com.snakelord.pets.marsroverphotos.data.mapper.RoversResponseMapper
import dagger.Module
import dagger.Provides

@Module
class RoversMapperModule {

    @Provides
    fun provideRoversResponseMapper() = RoversResponseMapper()
}