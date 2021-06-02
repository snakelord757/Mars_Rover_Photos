package com.snakelord.pets.marsroverphotos.domain.interactor.photos

import com.snakelord.pets.marsroverphotos.data.model.Photo

interface PhotosInteractor {
    suspend fun getPhotosByDate(formattedDate: String): Array<Photo>
}