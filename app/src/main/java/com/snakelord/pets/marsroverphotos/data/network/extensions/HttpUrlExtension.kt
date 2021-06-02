package com.snakelord.pets.marsroverphotos.data.network.extensions

import okhttp3.HttpUrl

fun HttpUrl.addQueryParameter(name: String, value: String): HttpUrl {
    return this.newBuilder()
        .addQueryParameter(name, value)
        .build()
}

fun HttpUrl.addQueryPath(name: String): HttpUrl {
    return this.newBuilder()
        .addPathSegment(name)
        .build()
}