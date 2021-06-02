package com.snakelord.pets.marsroverphotos.data.network

import com.snakelord.pets.marsroverphotos.data.network.extensions.addQueryPath
import okhttp3.HttpUrl

object ApiBaseUrl {

    private const val URL_SCHEME = "https"
    private const val URL_HOST = "api.nasa.gov"
    private const val URL_MARS_PHOTOS_PATH = "mars-photos"
    private const val URL_API_PATH = "api"
    private const val URL_VERSION_PATH = "v1"
    private const val URL_ROVERS_PATH = "rovers"
    private const val URL_GENERATION_PATH = "curiosity"
    private const val URL_ROVER_PHOTOS = "photos"

    private val url = HttpUrl.Builder()
        .scheme(URL_SCHEME)
        .host(URL_HOST)
        .addPathSegment(URL_MARS_PHOTOS_PATH)
        .addPathSegment(URL_API_PATH)
        .addPathSegment(URL_VERSION_PATH)
        .addPathSegment(URL_ROVERS_PATH)
        .build()

    fun getPhotosUrl(): HttpUrl {
        return url
            .addQueryPath(URL_GENERATION_PATH)
            .addQueryPath(URL_ROVER_PHOTOS)
    }

    fun getRoversUrl(): HttpUrl = url
}