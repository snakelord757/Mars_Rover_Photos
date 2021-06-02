package com.snakelord.pets.marsroverphotos.data.network.api.photos

import com.snakelord.pets.marsroverphotos.data.network.ApiBaseUrl
import com.snakelord.pets.marsroverphotos.data.network.extensions.addQueryParameter
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class MarsRoverPhotosApiImpl @Inject constructor(private val okHttpClient: OkHttpClient) :
    MarsRoverPhotosApi {

    private val baseUrl = ApiBaseUrl.getPhotosUrl()

    override suspend fun getPhotosByDate(formattedDate: String): Response {
        val request = Request.Builder()
            .url(baseUrl.addQueryParameter(EARTH_DATE_PARAMETER, formattedDate))
            .build()
        return getResponse(request)
    }


    private fun getResponse(request: Request): Response {
        return okHttpClient
            .newCall(request)
            .execute()
    }

    companion object {
        private const val EARTH_DATE_PARAMETER = "earth_date"
    }

}