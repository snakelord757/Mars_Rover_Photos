package com.snakelord.pets.marsroverphotos.domain.extensions

import okhttp3.Response

fun Response.isEmpty(): Boolean {
    return  body?.contentLength() == 0L
}