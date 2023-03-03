package com.alex.movila.ui.movie_detail.viewmodel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.alex.movila.core.MovieResult
import com.alex.movila.domain.use_cases.GetMovieDetailUseCase
import com.example.movieapp.data.model.moviedetail.MovieDetail
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class MovieDetailViewModel @Inject constructor(private val getMovieDetailUseCase: GetMovieDetailUseCase): ViewModel() {
    private val _movieDetail:MutableLiveData<MovieDetail> = MutableLiveData()
    val movieDetail: LiveData<MovieDetail> = _movieDetail

    fun getMovieDetail(id: String){
        viewModelScope.launch {
            val result = getMovieDetailUseCase(id)
            when(result){
                is MovieResult.Success ->{
                    _movieDetail.value = result.let { it.data }
                }

                is MovieResult.Error -> {
                    Log.e("ERROR", result.exception?.message ?: "Error desconocido")
                }
                else -> Log.d("MovieHomeViewModel", "Error getMovies: Error Desconocido")
            }
        }
    }
}