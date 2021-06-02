package com.snakelord.pets.marsroverphotos.di.modules.rovers

import com.snakelord.pets.marsroverphotos.data.network.api.rovers.MarsRoversApi
import com.snakelord.pets.marsroverphotos.data.network.api.rovers.MarsRoversApiImpl
import dagger.Binds
import dagger.Module

@Module
interface MarsRoversApiModule {
    @Binds
    fun bindsMarsRoversApi(marsRoversApiImpl: MarsRoversApiImpl): MarsRoversApi
}