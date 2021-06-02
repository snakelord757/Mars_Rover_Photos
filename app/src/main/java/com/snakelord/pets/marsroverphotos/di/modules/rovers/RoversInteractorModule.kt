package com.snakelord.pets.marsroverphotos.di.modules.rovers

import com.snakelord.pets.marsroverphotos.domain.interactor.rovers.RoversInteractor
import com.snakelord.pets.marsroverphotos.domain.interactor.rovers.RoversInteractorImpl
import dagger.Binds
import dagger.Module

@Module
interface RoversInteractorModule {
    @Binds
    fun bindsRoverInteractor(roversInteractorImpl: RoversInteractorImpl): RoversInteractor
}