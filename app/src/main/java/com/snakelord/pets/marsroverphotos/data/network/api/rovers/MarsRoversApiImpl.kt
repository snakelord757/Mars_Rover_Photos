package com.snakelord.pets.marsroverphotos.data.network.api.rovers

import com.snakelord.pets.marsroverphotos.data.mapper.RoversResponseMapper
import com.snakelord.pets.marsroverphotos.data.model.Rover
import com.snakelord.pets.marsroverphotos.data.network.ApiBaseUrl
import com.snakelord.pets.marsroverphotos.data.network.extensions.addQueryPath
import com.snakelord.pets.marsroverphotos.data.network.model.State
import okhttp3.*
import java.io.IOException
import javax.inject.Inject

class MarsRoversApiImpl @Inject constructor(
    private val okHttpClient: OkHttpClient,
    private val mapper: RoversResponseMapper) : MarsRoversApi {

    private val baseUrl = ApiBaseUrl.getRoversUrl()

    override suspend fun getInfoAbout(
        roverName: String,
        onResultReceived: (State.Success<Rover>) -> Unit,
        onReceiveFailed: (State.Error) -> Unit
    ) {
        val request = Request.Builder()
            .url(baseUrl.addQueryPath(roverName))
            .build()
        getResponse(request, onResultReceived, onReceiveFailed)
    }

    private fun getResponse(
        request: Request,
        onResultReceived: (State.Success<Rover>) -> Unit,
        onReceiveFailed: (State.Error) -> Unit
    ) {
        okHttpClient
            .newCall(request)
            .enqueue(object : Callback {
                override fun onFailure(call: Call, e: IOException) {
                    onReceiveFailed.invoke(State.Error(e.localizedMessage!!))
                }

                override fun onResponse(call: Call, response: Response) {
                    onResultReceived.invoke(State.Success(mapper.map(response)))
                }
            })
    }

}