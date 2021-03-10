package com.rasel.basicutils.extensions

import java.text.SimpleDateFormat
import java.util.*

fun String.toTimeOnly(): String? {
    val input = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val output = SimpleDateFormat("hh:mm a", Locale.getDefault())

    return try {
        val innerDate = input.parse(this) ?: Date()
        output.format(innerDate)
    } catch (ex: Exception) {
        null
    }
}

fun String.toFormattedDate(outputFormat: String = "EEE, d MMM yyyy hh:mm a"): String? {
    val input = SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.getDefault())
    val output = SimpleDateFormat(outputFormat, Locale.getDefault())

    return try {
        val innerDate = input.parse(this) ?: Date()
        output.format(innerDate)
    } catch (ex: Exception) {
        null
    }
}