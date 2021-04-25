package com.snakelord.pets.marsroverphotos.data.repositories

import com.snakelord.pets.marsroverphotos.data.model.Photo

interface PhotosRepository {
    suspend fun getPhotosByDate(formattedDate: String): Array<Photo>
}