package com.snakelord.pets.marsroverphotos.data.network.api.photos

import okhttp3.Response

interface MarsRoverPhotosApi {
    suspend fun getPhotosByDate(formattedDate: String): Response
}