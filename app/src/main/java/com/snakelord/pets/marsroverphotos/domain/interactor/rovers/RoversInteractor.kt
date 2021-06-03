package com.snakelord.pets.marsroverphotos.domain.interactor.rovers

import com.snakelord.pets.marsroverphotos.data.model.Rover
import com.snakelord.pets.marsroverphotos.data.network.model.State

interface RoversInteractor {
    suspend fun getInfoAbout(
        name: String,
        onResultReceived: (State.Success<Rover>) -> Unit,
        onReceiveFailed: (State.Error) -> Unit)
}