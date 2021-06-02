package com.snakelord.pets.marsroverphotos.data.network.api.rovers

import okhttp3.Response

interface MarsRoversApi {
    suspend fun getInfoAbout(roverName: String): Response
}