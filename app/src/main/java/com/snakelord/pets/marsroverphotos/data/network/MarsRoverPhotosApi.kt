package com.snakelord.pets.marsroverphotos.data.network

import okhttp3.Response

interface MarsRoverPhotosApi {
    suspend fun getPhotosByDate(formattedDate: String): Response
    suspend fun getPhotosFromCamera(camera: String): Response
}