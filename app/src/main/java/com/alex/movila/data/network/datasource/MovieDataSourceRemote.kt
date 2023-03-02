package com.alex.movila.data.network.datasource

import com.alex.movila.core.MovieResult
import com.alex.movila.data.network.model.Movie
import com.alex.movila.data.network.model.MovieList

interface MovieDataSourceRemote {
    suspend fun getUpComingMovies():MovieResult<List<Movie>>
}