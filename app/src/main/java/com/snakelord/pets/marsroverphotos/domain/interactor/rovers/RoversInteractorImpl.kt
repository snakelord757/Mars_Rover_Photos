package com.snakelord.pets.marsroverphotos.domain.interactor.rovers

import com.snakelord.pets.marsroverphotos.data.model.Rover
import com.snakelord.pets.marsroverphotos.data.network.model.State
import com.snakelord.pets.marsroverphotos.data.repositories.RoversRepository
import javax.inject.Inject

class RoversInteractorImpl @Inject constructor(
    private val roversRepository: RoversRepository) : RoversInteractor {

    override suspend fun getInfoAbout(
        name: String,
        onResultReceived: (State.Success<Rover>) -> Unit,
        onReceiveFailed: (State.Error) -> Unit
    ) {
        roversRepository.getInfoAbout(name, onResultReceived, onReceiveFailed)
    }

}