package com.snakelord.pets.marsroverphotos.data.repositories

import com.snakelord.pets.marsroverphotos.data.model.Rover
import com.snakelord.pets.marsroverphotos.data.network.model.State

interface RoversRepository {
    suspend fun getInfoAbout(
        name: String,
        onResultReceived: (State.Success<Rover>) -> Unit,
        onReceiveFailed: (State.Error) -> Unit)
}