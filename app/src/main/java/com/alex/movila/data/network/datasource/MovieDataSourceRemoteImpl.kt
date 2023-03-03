package com.alex.movila.data.network.datasource

import com.alex.movila.core.MovieResult
import com.alex.movila.data.network.api.ApiWebService
import com.alex.movila.data.network.model.popular_movies.Movie
import com.alex.movila.utils.Constants
import com.example.movieapp.data.model.moviedetail.MovieDetail
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieDataSourceRemoteImpl @Inject constructor(private val apiWebService: ApiWebService):MovieDataSourceRemote {
    override suspend fun getPopularMovies(): MovieResult<List<Movie>> {
        return withContext(Dispatchers.IO){
            try {
                val movieResult = apiWebService.getPopularMovies(Constants.API_KEY)
                MovieResult.Success(movieResult.results)
            }catch (e: Exception){
                e.printStackTrace()
                MovieResult.Error(e)
            }
        }
    }

    override suspend fun getMovieDetail(id: String): MovieResult<MovieDetail> {
        return withContext(Dispatchers.IO){
            try {
                val movieResult = apiWebService.getMovieDetail(id,Constants.API_KEY)
                MovieResult.Success(movieResult)
            }catch (e: Exception){
                e.printStackTrace()
                MovieResult.Error(e)
            }
        }
    }

}