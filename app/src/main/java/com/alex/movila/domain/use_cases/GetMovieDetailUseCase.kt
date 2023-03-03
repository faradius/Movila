package com.alex.movila.domain.use_cases

import com.alex.movila.core.MovieResult
import com.alex.movila.data.repository.MovieRepository
import com.example.movieapp.data.model.moviedetail.MovieDetail
import javax.inject.Inject

class GetMovieDetailUseCase @Inject constructor(private val repository: MovieRepository) {
    suspend operator fun invoke(id: String): MovieResult<MovieDetail>{
        return repository.getMovieDetail(id)
    }
}