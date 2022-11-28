package com.alex.movila.ui.movie_home

import android.app.ActionBar
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager2.widget.ViewPager2
import com.alex.movila.R
import com.alex.movila.ui.adapters.MovieAdapterD1
import com.alex.movila.ui.adapters.MovieAdapterD2
import com.alex.movila.ui.adapters.ViewPagerMovieMainAdapter
import me.relex.circleindicator.CircleIndicator3


class MovieHomeFragment : Fragment() {

    private var imagesListUpcomingMovies = mutableListOf<Int>()
    private var imagesListPopularMovies = mutableListOf<Int>()
    private var imagesListTopRatedMovies = mutableListOf<Int>()
    private var actionBar:androidx.appcompat.app.ActionBar? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_movie_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //actionBar?.setDisplayShowTitleEnabled(false)
        //actionBar?.setBackgroundDrawable(resources.getDrawable(R.drawable.movie_example2))



        postToList()
        initVPUpcomingMovies()
        initRvPopularMovies()
        initRvTopRatedMovies()

    }

    private fun addMovieToList(image:Int){
        imagesListUpcomingMovies.add(image)
        imagesListPopularMovies.add(image)
        imagesListTopRatedMovies.add(image)
    }

    private fun postToList(){
        for (i in 1..5){
            addMovieToList(R.drawable.movie_example)
        }
    }

    private fun initVPUpcomingMovies(){
        val viewPagerMovies = view?.findViewById<ViewPager2>(R.id.viewPagerMovies)
        val indicatorViewPager = view?.findViewById<CircleIndicator3>(R.id.indicatorViewPager)

        viewPagerMovies?.adapter = ViewPagerMovieMainAdapter(imagesListUpcomingMovies)
        viewPagerMovies?.orientation = ViewPager2.ORIENTATION_HORIZONTAL
        indicatorViewPager?.setViewPager(viewPagerMovies)
    }

    private fun initRvPopularMovies(){
        val rvPopularMovies = view?.findViewById<RecyclerView>(R.id.rvPopularMovies)
        rvPopularMovies?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapter = MovieAdapterD1(imagesListPopularMovies)
        rvPopularMovies?.adapter = adapter

    }

    private fun initRvTopRatedMovies(){
        val rvTopRatedMovies = view?.findViewById<RecyclerView>(R.id.rvTopRatedMovies)
        rvTopRatedMovies?.layoutManager = LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false)
        val adapter = MovieAdapterD2(imagesListTopRatedMovies)
        rvTopRatedMovies?.adapter = adapter

    }

}