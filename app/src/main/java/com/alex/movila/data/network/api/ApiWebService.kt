package com.alex.movila.data.network.api

import com.alex.movila.data.network.model.popular_movies.Movie
import com.alex.movila.data.network.model.popular_movies.MovieList
import com.example.movieapp.data.model.moviedetail.MovieDetail
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiWebService {

    @GET("movie/upcoming")
    suspend fun getPopularMovies(@Query ("api_key") apiKey: String): MovieList

    @GET("movie/{id}")
    suspend fun getMovieDetail(@Path("id") id: String, @Query ("api_key") apiKey: String): MovieDetail
}