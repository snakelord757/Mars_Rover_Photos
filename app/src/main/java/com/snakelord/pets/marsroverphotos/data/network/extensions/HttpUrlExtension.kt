package com.snakelord.pets.marsroverphotos.data.network.extensions

import okhttp3.HttpUrl

fun <T> HttpUrl.addQueryParameter(name: String, value: T): HttpUrl {
    return this.newBuilder()
        .addQueryParameter(name, value.toString())
        .build()
}