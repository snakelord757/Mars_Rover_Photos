package com.snakelord.pets.marsroverphotos.data.network

import com.snakelord.pets.marsroverphotos.data.network.extensions.addQueryParameter
import okhttp3.HttpUrl
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class MarsRoverPhotosApiImpl @Inject constructor(private val okHttpClient: OkHttpClient) :
    MarsRoverPhotosApi {

    private val baseURL = HttpUrl.Builder()
        .scheme(URL_SCHEME)
        .host(URL_HOST)
        .addPathSegment(URL_MARS_PHOTOS_PATH)
        .addPathSegment(URL_API_PATH)
        .addPathSegment(URL_VERSION_PATH)
        .addPathSegment(URL_ROVERS_PATH)
        .addPathSegment(URL_GENERATION_PATH)
        .addPathSegment(URL_ROVER_PHOTOS)
        .build()

    override suspend fun getPhotosByDate(formattedDate: String): Response {
        return getResponse(buildRequest(EARTH_DATE_PARAMETER, formattedDate))
    }

    override suspend fun getPhotosFromCamera(camera: String): Response {
        return getResponse(buildRequest(CAMERA_PARAMETER, camera))
    }

    private fun <T> buildRequest(parameterName: String, parameterValue: T): Request {
        return Request.Builder()
            .url(baseURL.addQueryParameter(parameterName, parameterValue))
            .build()
    }

    private fun getResponse(request: Request): Response {
        return okHttpClient
            .newCall(request)
            .execute()
    }

    companion object {
        private const val URL_SCHEME = "https"
        private const val URL_HOST = "api.nasa.gov"
        private const val URL_MARS_PHOTOS_PATH = "mars-photos"
        private const val URL_API_PATH = "api"
        private const val URL_VERSION_PATH = "v1"
        private const val URL_ROVERS_PATH = "rovers"
        private const val URL_GENERATION_PATH = "curiosity"
        private const val URL_ROVER_PHOTOS = "photos"
        private const val CAMERA_PARAMETER = "camera"
        private const val EARTH_DATE_PARAMETER = "earth_date"
    }

}