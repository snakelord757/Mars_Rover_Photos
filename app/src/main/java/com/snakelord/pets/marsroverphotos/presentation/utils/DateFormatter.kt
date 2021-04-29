package com.snakelord.pets.marsroverphotos.presentation.utils

object DateFormatter {
    fun formatDate(day: Int, month: Int, year: Int): String {
        return "$year-$month-$day"
    }
}