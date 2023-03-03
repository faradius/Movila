package com.alex.movila.data.repository

import com.alex.movila.core.MovieResult
import com.alex.movila.data.network.datasource.MovieDataSourceRemote
import com.alex.movila.data.network.model.popular_movies.Movie
import com.example.movieapp.data.model.moviedetail.MovieDetail
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(private val remoteDataSource:MovieDataSourceRemote): MovieRepository {
    override suspend fun getPopularMovies(): MovieResult<List<Movie>> {
        return remoteDataSource.getPopularMovies()
    }

    override suspend fun getMovieDetail(id: String): MovieResult<MovieDetail> {
        return remoteDataSource.getMovieDetail(id)
    }
}