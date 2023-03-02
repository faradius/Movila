package com.alex.movila.data.repository

import com.alex.movila.core.MovieResult
import com.alex.movila.data.network.model.Movie
import com.alex.movila.data.network.model.MovieList

interface MovieRepository {
    suspend fun getPopularMovies(): MovieResult<List<Movie>>
}