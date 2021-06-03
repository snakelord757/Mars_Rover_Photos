package com.snakelord.pets.marsroverphotos.domain.interactor.photos

import com.snakelord.pets.marsroverphotos.data.model.Photo
import com.snakelord.pets.marsroverphotos.data.network.callback.OnResultListener
import com.snakelord.pets.marsroverphotos.data.network.model.State
import com.snakelord.pets.marsroverphotos.data.repositories.PhotosRepository
import javax.inject.Inject

class PhotosInteractorImpl @Inject constructor(
    private val repository: PhotosRepository) : PhotosInteractor {

    override suspend fun getPhotosByDate(
        formattedDate: String,
        onResultReceived: (State.Success<Array<Photo>>) -> Unit,
        onReceiveFailed: (State.Error) -> Unit
    ) {
        repository.getPhotosByDate(formattedDate, onResultReceived, onReceiveFailed)
    }
}