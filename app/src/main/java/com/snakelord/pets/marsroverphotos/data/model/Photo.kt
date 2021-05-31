package com.snakelord.pets.marsroverphotos.data.model

import com.snakelord.pets.marsroverphotos.domain.extensions.EMPTY
import java.io.Serializable

class Photo : Serializable {
    var photoLink: String = String.EMPTY
    var earthDate: String = String.EMPTY
    var fromCamera: Camera = Camera()
    var fromRover: Rover = Rover()
}
