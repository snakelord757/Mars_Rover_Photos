package com.snakelord.pets.marsroverphotos.data.model

data class Photo(
    val photoLink: String = "",
    val earthDate: String = "",
    val fromCamera: Camera = Camera(),
    val fromRover: Rover = Rover(),
)
