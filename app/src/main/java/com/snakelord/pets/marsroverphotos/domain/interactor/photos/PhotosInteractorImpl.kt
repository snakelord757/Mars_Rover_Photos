package com.snakelord.pets.marsroverphotos.domain.interactor.photos

import com.snakelord.pets.marsroverphotos.data.model.Photo
import com.snakelord.pets.marsroverphotos.data.repositories.PhotosRepository
import javax.inject.Inject

class PhotosInteractorImpl @Inject constructor(private val repository: PhotosRepository) :
    PhotosInteractor {
    override suspend fun getPhotosByDate(formattedDate: String): Array<Photo> {
        return repository.getPhotosByDate(formattedDate)
    }
}