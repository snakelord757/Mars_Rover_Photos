package com.snakelord.pets.marsroverphotos.data.repositories

import com.snakelord.pets.marsroverphotos.data.model.Rover
import com.snakelord.pets.marsroverphotos.data.network.api.rovers.MarsRoversApi
import com.snakelord.pets.marsroverphotos.data.network.model.State
import javax.inject.Inject

class RoversRepositoryImpl @Inject constructor(
    private val roversApi: MarsRoversApi): RoversRepository {

    override suspend fun getInfoAbout(
        name: String,
        onResultReceived: (State.Success<Rover>) -> Unit,
        onReceiveFailed: (State.Error) -> Unit
    ) {
        roversApi.getInfoAbout(name, onResultReceived, onReceiveFailed)
    }
}