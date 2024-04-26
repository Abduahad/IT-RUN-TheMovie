package com.example.themovie.ui

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.themovie.domain.model.MovieEntity
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel:ViewModel() {

    fun fetchMovies():LiveData<ArrayList<MovieEntity>> {
        val result:MutableLiveData<ArrayList<MovieEntity>> = MutableLiveData()
            viewModelScope.launch(Dispatchers.IO) {
                val movies = ArrayList<MovieEntity>()
                movies.add(MovieEntity(1, "The Shawshank Redemption", "/9cqNxx0GxF0bflZmeSMuL5tnGzr.jpg"))
                movies.add(MovieEntity(1, "The Shawshank Redemption", "/9cqNxx0GxF0bflZmeSMuL5tnGzr.jpg"))
                movies.add(MovieEntity(1, "The Shawshank Redemption", "/9cqNxx0GxF0bflZmeSMuL5tnGzr.jpg"))
                movies.add(MovieEntity(1, "The Shawshank Redemption", "/9cqNxx0GxF0bflZmeSMuL5tnGzr.jpg"))
                movies.add(MovieEntity(1, "The Shawshank Redemption", "/9cqNxx0GxF0bflZmeSMuL5tnGzr.jpg"))
                result.postValue(movies)
            }
        return result
    }
}