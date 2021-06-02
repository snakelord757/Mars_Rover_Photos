package com.snakelord.pets.marsroverphotos.data.model

import com.snakelord.pets.marsroverphotos.domain.extensions.EMPTY

data class Rover(
    val roverName: String = String.EMPTY,
    val landingDate: String = String.EMPTY,
    val launchDate: String = String.EMPTY,
    val status: String = String.EMPTY,
    val sol: Int = 0,
    val lastPhotoDate: String = String.EMPTY,
    val totalPhotos: Int = 0,
    val cameras: Array<Camera> = emptyArray()
)
