package com.snakelord.pets.marsroverphotos.di.modules

import com.snakelord.pets.marsroverphotos.data.network.ApiKeyInterceptor
import dagger.Module
import dagger.Provides
import okhttp3.OkHttpClient

@Module
class OkHttpClientModule {
    @Provides
    fun provideOkHttpClient(interceptor: ApiKeyInterceptor) = OkHttpClient.Builder()
        .addInterceptor(interceptor)
        .build()
}