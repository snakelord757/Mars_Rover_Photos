package com.snakelord.pets.marsroverphotos.data.mapper

interface Mapper<in I, out O> {
    fun map(input: I): O
}