package com.alex.movila.ui.movie_detail.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.alex.movila.R
import com.alex.movila.databinding.FragmentMovieDetailBinding
import com.alex.movila.ui.movie_detail.viewmodel.MovieDetailViewModel
import com.alex.movila.ui.movie_home.adapters.MovieAdapterD1
import com.alex.movila.utils.Constants
import com.alex.movila.utils.toMovieUrl
import com.bumptech.glide.Glide
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MovieDetailFragment : Fragment() {

    private lateinit var id:String
    private val viewModel by viewModels<MovieDetailViewModel>()
    private lateinit var binding: FragmentMovieDetailBinding


    private var imagesListRecommendationsMovies = mutableListOf<Int>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let { bundle ->
            id = bundle.getString(Constants.MOVI_ID)!!
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        subscribeMovieDetail()
        return inflater.inflate(R.layout.fragment_movie_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentMovieDetailBinding.bind(view)
        viewModel.getMovieDetail(id)
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

    fun subscribeMovieDetail(){
        viewModel.movieDetail.observe(viewLifecycleOwner){movie ->
            binding.tvTitleMovie.text = movie.title
            binding.tvDescriptionMovie.text = movie.overview

            Glide.with(requireContext())
                .load(movie.poster_path.toMovieUrl())
                .into(binding.ivMovie)

            Glide.with(requireContext())
                .load(movie.backdrop_path.toMovieUrl())
                .into(binding.ivBackgroundPosterMovie)

        }
    }

    private fun initRvRecommendatiosMovies(){
        val rvRecommendationsMovies = view?.findViewById<RecyclerView>(R.id.rvRecommendations)
        rvRecommendationsMovies?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
//        val adapter = MovieAdapterD1(imagesListRecommendationsMovies)
//        rvRecommendationsMovies?.adapter = adapter

    }
}