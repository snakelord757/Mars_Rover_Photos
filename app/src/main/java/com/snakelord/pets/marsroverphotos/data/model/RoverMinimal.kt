package com.snakelord.pets.marsroverphotos.data.model

import com.snakelord.pets.marsroverphotos.domain.extensions.EMPTY

data class RoverMinimal(
    val roverName: String = String.EMPTY,
    val roverStatus: String = String.EMPTY
)
