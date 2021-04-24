package com.snakelord.pets.marsroverphotos.data.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ApiKeyInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
       val newUrl = chain.request().url.newBuilder()
           .addQueryParameter(API_KEY_PARAMETER, API_KEY)
           .build()
        val request = chain.request().newBuilder().url(newUrl).build()
        return chain.proceed(request)
    }

    companion object {
        private const val API_KEY_PARAMETER = "api_key"
        //TODO("Insert your own api key generated on https://api.nasa.gov/")
        private const val API_KEY = "DEMO_KEY"
    }
}