package com.alex.movila.data.network.api

import com.alex.movila.data.network.model.MovieList
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiWebService {

    @GET("movie/upcoming")
    suspend fun getPopularMovies(@Query ("api_key") apiKey: String): MovieList
}