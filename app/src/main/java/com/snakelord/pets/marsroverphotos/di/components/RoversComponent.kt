package com.snakelord.pets.marsroverphotos.di.components

import com.snakelord.pets.marsroverphotos.di.modules.OkHttpClientModule
import com.snakelord.pets.marsroverphotos.di.modules.ViewModelFactoryModule
import com.snakelord.pets.marsroverphotos.di.modules.rovers.*
import com.snakelord.pets.marsroverphotos.presentation.rovers.RoversFragment
import dagger.Component

@Component(
    modules = [
        MarsRoversApiModule::class, RoversInteractorModule::class,
        RoversMapperModule::class, RoversRepositoryModule::class,
        RoversViewModelModule::class, OkHttpClientModule::class,
        ViewModelFactoryModule::class]
)
interface RoversComponent {
    fun inject(rovers: RoversFragment)
}