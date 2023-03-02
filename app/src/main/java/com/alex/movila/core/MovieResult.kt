package com.alex.movila.core

sealed class MovieResult<out R>{
    object Loading: MovieResult<Nothing>()
    data class Success<T>(val data: T): MovieResult<T>()
    data class Error<out T>(val exception: Exception?): MovieResult<T>()
}
