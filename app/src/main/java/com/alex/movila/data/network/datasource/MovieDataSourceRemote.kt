package com.alex.movila.data.network.datasource

import com.alex.movila.core.MovieResult
import com.alex.movila.data.network.model.popular_movies.Movie
import com.example.movieapp.data.model.moviedetail.MovieDetail

interface MovieDataSourceRemote {
    suspend fun getPopularMovies():MovieResult<List<Movie>>

    suspend fun getMovieDetail(id: String): MovieResult<MovieDetail>
}