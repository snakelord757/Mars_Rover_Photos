package com.snakelord.pets.marsroverphotos.data.network.api.rovers

import com.snakelord.pets.marsroverphotos.data.network.ApiBaseUrl
import com.snakelord.pets.marsroverphotos.data.network.extensions.addQueryPath
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import javax.inject.Inject

class MarsRoversApiImpl @Inject constructor(private val okHttpClient: OkHttpClient) :
    MarsRoversApi {

    private val baseUrl = ApiBaseUrl.getRoversUrl()

    override suspend fun getInfoAbout(roverName: String): Response {
        val request = Request.Builder()
            .url(baseUrl.addQueryPath(roverName))
            .build()
        return getResponse(request)
    }

    private fun getResponse(request: Request): Response {
        return okHttpClient
            .newCall(request)
            .execute()
    }

}