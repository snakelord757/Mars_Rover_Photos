package com.snakelord.pets.marsroverphotos.data.network.api.photos

import com.snakelord.pets.marsroverphotos.data.mapper.PhotosResponseMapper
import com.snakelord.pets.marsroverphotos.data.model.Photo
import com.snakelord.pets.marsroverphotos.data.network.ApiBaseUrl
import com.snakelord.pets.marsroverphotos.data.network.extensions.addQueryParameter
import com.snakelord.pets.marsroverphotos.data.network.model.State
import okhttp3.*
import java.io.IOException
import javax.inject.Inject

class MarsRoverPhotosApiImpl @Inject constructor(
    private val okHttpClient: OkHttpClient,
    private val mapper: PhotosResponseMapper
) : MarsRoverPhotosApi {

    private val baseUrl = ApiBaseUrl.getPhotosUrl()

    override suspend fun getPhotosByDate(
        formattedDate: String,
        onResultReceived: (State.Success<Array<Photo>>) -> Unit,
        onReceiveFailed: (State.Error) -> Unit
    ) {
        val request = Request.Builder()
            .url(baseUrl.addQueryParameter(EARTH_DATE_PARAMETER, formattedDate))
            .build()
        getResponse(request, onResultReceived, onReceiveFailed)
    }

    private fun getResponse(
        request: Request,
        onResultReceived: (State.Success<Array<Photo>>) -> Unit,
        onReceiveFailed: (State.Error) -> Unit
    ) {
        okHttpClient
            .newCall(request)
            .enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    onReceiveFailed.invoke(State.Error(e.message!!))
                }

                override fun onResponse(call: Call, response: Response) {
                    onResultReceived.invoke(State.Success(mapper.map(response)))
                }
            })
    }

    companion object {
        private const val EARTH_DATE_PARAMETER = "earth_date"
    }

}