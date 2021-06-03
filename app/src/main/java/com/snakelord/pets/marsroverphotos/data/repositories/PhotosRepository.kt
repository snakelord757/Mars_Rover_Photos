package com.snakelord.pets.marsroverphotos.data.repositories

import com.snakelord.pets.marsroverphotos.data.model.Photo
import com.snakelord.pets.marsroverphotos.data.network.model.State

interface PhotosRepository {
    suspend fun getPhotosByDate(
        formattedDate: String,
        onResultReceived: (State.Success<Array<Photo>>) -> Unit,
        onReceiveFailed: (State.Error) -> Unit)
}