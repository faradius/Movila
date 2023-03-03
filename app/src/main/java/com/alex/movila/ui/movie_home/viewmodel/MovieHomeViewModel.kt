package com.alex.movila.ui.movie_home.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.movila.core.MovieResult
import com.alex.movila.data.repository.MovieRepository
import com.alex.movila.domain.model.PopularMoviesUI
import com.alex.movila.domain.model.toPopularMoviesUI
import com.alex.movila.domain.use_cases.GetPopularMoviesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieHomeViewModel @Inject constructor(private val getPopularMoviesUseCase: GetPopularMoviesUseCase): ViewModel() {

    private val _movies: MutableLiveData<List<PopularMoviesUI>> = MutableLiveData()
    val movies: LiveData<List<PopularMoviesUI>> = _movies

    fun getMovies(){
        viewModelScope.launch {
            val result = getPopularMoviesUseCase()
            when(result){
                is MovieResult.Success -> {
                    _movies.value = result.data.map {
                        it.toPopularMoviesUI()
                    }
                }
                is MovieResult.Error -> {
                    Log.e("ERROR", result.exception?.message ?: "Error desconocido")
                }
                else -> Log.d("MovieHomeViewModel", "Error getMovies: Error Desconocido")
            }
        }
    }
}