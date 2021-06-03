package com.snakelord.pets.marsroverphotos.data.network.model

sealed class State<out T> {
    data class Success<out T>(val data : T) : State<T>()
    data class Error(val errorMessage: String) : State<Nothing>()
}
