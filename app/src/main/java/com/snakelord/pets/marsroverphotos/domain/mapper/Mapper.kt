package com.snakelord.pets.marsroverphotos.domain.mapper

interface Mapper<in I, out O> {
    fun map(input: I): O
}