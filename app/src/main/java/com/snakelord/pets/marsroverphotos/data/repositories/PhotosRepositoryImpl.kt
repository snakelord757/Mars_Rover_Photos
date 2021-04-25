package com.snakelord.pets.marsroverphotos.data.repositories

import com.snakelord.pets.marsroverphotos.data.model.Photo
import com.snakelord.pets.marsroverphotos.data.network.MarsRoverPhotosApi
import com.snakelord.pets.marsroverphotos.domain.mapper.PhotosResponseMapper
import javax.inject.Inject

class PhotosRepositoryImpl @Inject constructor(
    private val marsRoverPhotosApi: MarsRoverPhotosApi,
    private val photosResponseMapper: PhotosResponseMapper
) : PhotosRepository {

    override suspend fun getPhotosByDate(formattedDate: String): Array<Photo> {
        return photosResponseMapper
            .map(marsRoverPhotosApi.getPhotosByDate(formattedDate))
    }
}