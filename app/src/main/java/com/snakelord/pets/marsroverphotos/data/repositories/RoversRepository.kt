package com.snakelord.pets.marsroverphotos.data.repositories

import com.snakelord.pets.marsroverphotos.data.model.Rover

interface RoversRepository {
    suspend fun getInfoAbout(name: String): Rover
}