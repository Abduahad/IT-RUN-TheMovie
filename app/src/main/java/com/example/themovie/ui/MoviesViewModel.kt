package com.example.themovie.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.example.themovie.core.ui.BaseViewModel
import com.example.data.mapper.MovieEntityMapper
import com.example.data.model.MovieResult
import com.example.domain.model.MovieEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel:BaseViewModel() {

    fun fetchMovies():LiveData<List<MovieEntity>> {
        val result:MutableLiveData<List<MovieEntity>> = MutableLiveData()
            viewModelScope.launch(Dispatchers.IO) {
                val movieResult: MovieResult? = movieService.getTopRatedMovies().body() as MovieResult
                movieResult?.let {
                    result.postValue(MovieEntityMapper().invoke(it))
                }
            }
        return result
    }
}