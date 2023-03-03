package com.alex.movila.data.network.model.popular_movies

data class MovieList(
    val page: Int,
    val results: List<Movie>,
    val total_pages: Int,
    val total_results: Int
)