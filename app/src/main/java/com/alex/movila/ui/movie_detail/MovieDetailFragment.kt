package com.alex.movila.ui.movie_detail

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alex.movila.R
import com.alex.movila.ui.adapters.MovieAdapterD1


class MovieDetailFragment : Fragment() {

    private var imagesListRecommendationsMovies = mutableListOf<Int>()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        postToList()
        initRvRecommendatiosMovies()
    }

    private fun addMovieToList(image:Int){
        imagesListRecommendationsMovies.add(image)
    }

    private fun postToList(){
        for (i in 1..5){
            addMovieToList(R.drawable.movie_example)
        }
    }

    private fun initRvRecommendatiosMovies(){
        val rvRecommendationsMovies = view?.findViewById<RecyclerView>(R.id.rvRecommendations)
        rvRecommendationsMovies?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapter = MovieAdapterD1(imagesListRecommendationsMovies)
        rvRecommendationsMovies?.adapter = adapter

    }
}