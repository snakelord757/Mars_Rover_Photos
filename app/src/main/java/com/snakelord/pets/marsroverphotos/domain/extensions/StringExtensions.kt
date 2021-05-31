package com.snakelord.pets.marsroverphotos.domain.extensions

import java.text.SimpleDateFormat
import java.util.Locale.getDefault

val String.Companion.EMPTY: String
    get() = ""

fun String.Companion.parseDate(date: String): String {
    val parsePattern = "yyyy-MM-dd"
    val parsedDate = SimpleDateFormat(parsePattern, getDefault()).parse(date)
    return SimpleDateFormat("d MMMM yyyy", getDefault()).format(parsedDate!!)
}