package com.snakelord.pets.marsroverphotos.data.model

import com.snakelord.pets.marsroverphotos.domain.extensions.EMPTY

data class Rover(
    val roverName: String = String.EMPTY,
    val roverLaunchDate: String = String.EMPTY,
    val roverLandingDate: String = String.EMPTY,
    val roverStatus: String = String.EMPTY
)
