package com.alex.movila.data.network.datasource

import com.alex.movila.core.MovieResult
import com.alex.movila.data.network.model.MovieList
import com.alex.movila.data.network.api.ApiWebService
import com.alex.movila.data.network.model.Movie
import com.alex.movila.utils.Constants
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject

class MovieDataSourceRemoteImpl @Inject constructor(private val apiWebService: ApiWebService):MovieDataSourceRemote {
    override suspend fun getUpComingMovies(): MovieResult<List<Movie>> {
        return withContext(Dispatchers.IO){
            try {
                val movieResult = apiWebService.getUpComingMovies(Constants.API_KEY)
                MovieResult.Success(movieResult.results)
            }catch (e: Exception){
                e.printStackTrace()
                MovieResult.Error(e)
            }
        }
    }

}