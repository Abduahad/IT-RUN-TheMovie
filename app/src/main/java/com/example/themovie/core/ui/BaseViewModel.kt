package com.example.themovie.core.ui

import androidx.lifecycle.ViewModel
import com.example.data.MovieClient
import com.example.data.MovieService


open class BaseViewModel:ViewModel() {
    protected val movieService: MovieService = MovieClient.apiService
}