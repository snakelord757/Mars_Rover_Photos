package com.snakelord.pets.marsroverphotos.data.repositories

import com.snakelord.pets.marsroverphotos.data.model.Photo
import com.snakelord.pets.marsroverphotos.data.network.api.photos.MarsRoverPhotosApi
import com.snakelord.pets.marsroverphotos.data.mapper.PhotosResponseMapper
import com.snakelord.pets.marsroverphotos.data.network.callback.OnResultListener
import com.snakelord.pets.marsroverphotos.data.network.model.State
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(
    private val marsRoverPhotosApi: MarsRoverPhotosApi
) : PhotosRepository {

    override suspend fun getPhotosByDate(
        formattedDate: String,
        onResultReceived: (State.Success<Array<Photo>>) -> Unit,
        onReceiveFailed: (State.Error) -> Unit
    ) {
        marsRoverPhotosApi.getPhotosByDate(formattedDate, onResultReceived, onReceiveFailed)
    }
}