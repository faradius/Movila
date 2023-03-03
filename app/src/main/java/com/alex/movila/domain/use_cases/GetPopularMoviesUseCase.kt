package com.alex.movila.domain.use_cases

import com.alex.movila.core.MovieResult
import com.alex.movila.data.network.model.Movie
import com.alex.movila.data.repository.MovieRepository
import javax.inject.Inject

class GetPopularMoviesUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke():MovieResult<List<Movie>>{
        return repository.getPopularMovies()
    }
}