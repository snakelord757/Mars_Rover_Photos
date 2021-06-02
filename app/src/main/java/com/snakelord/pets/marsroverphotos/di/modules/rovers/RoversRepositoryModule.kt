package com.snakelord.pets.marsroverphotos.di.modules.rovers

import com.snakelord.pets.marsroverphotos.data.repositories.RoversRepository
import com.snakelord.pets.marsroverphotos.data.repositories.RoversRepositoryImpl
import dagger.Binds
import dagger.Module

@Module
interface RoversRepositoryModule {
    @Binds
    fun bindsRoversRepository(roversRepositoryImpl: RoversRepositoryImpl): RoversRepository
}