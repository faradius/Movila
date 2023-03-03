package com.alex.movila.domain.model

import com.alex.movila.data.network.model.popular_movies.Movie
import com.alex.movila.utils.toMovieUrl

data class PopularMoviesUI(
    val id: String,
    val imageUrl: String
)

fun Movie.toPopularMoviesUI(): PopularMoviesUI{
    return PopularMoviesUI(
        id = this.id.toString(),
        imageUrl = this.poster_path.toMovieUrl()
    )
}
