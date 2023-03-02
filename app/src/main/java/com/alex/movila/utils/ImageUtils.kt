package com.alex.movila.utils

import com.alex.movila.utils.Constants.IMAGE_URL_BASE

fun String.toMovieUrl(): String {
    return "$IMAGE_URL_BASE$this"
}