package com.snakelord.pets.marsroverphotos.data.network.api.rovers

import com.snakelord.pets.marsroverphotos.data.model.Rover
import com.snakelord.pets.marsroverphotos.data.network.model.State

interface MarsRoversApi {
    suspend fun getInfoAbout(
        roverName: String,
        onResultReceived: (State.Success<Rover>) -> Unit,
        onReceiveFailed: (State.Error) -> Unit)
}