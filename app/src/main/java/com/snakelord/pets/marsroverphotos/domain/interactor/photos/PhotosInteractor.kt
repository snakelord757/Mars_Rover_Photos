package com.snakelord.pets.marsroverphotos.domain.interactor.photos

import com.snakelord.pets.marsroverphotos.data.model.Photo
import com.snakelord.pets.marsroverphotos.data.network.model.State

interface PhotosInteractor {
    suspend fun getPhotosByDate(
        formattedDate: String,
        onResultReceived: (State.Success<Array<Photo>>) -> Unit,
        onReceiveFailed: (State.Error) -> Unit)
}