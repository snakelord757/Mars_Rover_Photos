package com.snakelord.pets.marsroverphotos.data.repositories

import com.snakelord.pets.marsroverphotos.data.mapper.RoversResponseMapper
import com.snakelord.pets.marsroverphotos.data.model.Rover
import com.snakelord.pets.marsroverphotos.data.network.api.rovers.MarsRoversApi
import javax.inject.Inject

class RoversRepositoryImpl @Inject constructor(
    private val roversApi: MarsRoversApi,
    private val roversMapper: RoversResponseMapper): RoversRepository {

    override suspend fun getInfoAbout(name: String): Rover {
        return roversMapper.map(roversApi.getInfoAbout(name))
    }
}