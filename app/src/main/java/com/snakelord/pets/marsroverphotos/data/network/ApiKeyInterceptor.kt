package com.snakelord.pets.marsroverphotos.data.network

import okhttp3.Interceptor
import okhttp3.Response
import javax.inject.Inject

class ApiKeyInterceptor @Inject constructor() : Interceptor {
    override fun intercept(chain: Interceptor.Chain): Response {
       val newUrl = chain.request().url.newBuilder()
           .addQueryParameter("api_key", API_KEY)
           .build()
        val request = chain.request().newBuilder().url(newUrl).build()
        return chain.proceed(request)
    }

    companion object {
        private const val API_KEY = "DEMO_KEY" // <-- Insert your own api key generated on https://api.nasa.gov/
    }
}