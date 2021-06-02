package com.snakelord.pets.marsroverphotos.di.modules.rovers

import androidx.lifecycle.ViewModel
import com.snakelord.pets.marsroverphotos.di.annotations.ViewModelKey
import com.snakelord.pets.marsroverphotos.presentation.rovers.RoversViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
interface RoversViewModelModule {
    @Binds
    @IntoMap
    @ViewModelKey(RoversViewModel::class)
    fun bindsRoversViewModule(roversViewModel: RoversViewModel): ViewModel
}