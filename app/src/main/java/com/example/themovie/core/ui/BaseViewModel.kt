package com.example.themovie.core.ui

import androidx.lifecycle.ViewModel
import com.example.themovie.data.MovieClient
import com.example.themovie.data.MovieService

open class BaseViewModel:ViewModel() {
    protected val movieService:MovieService = MovieClient.apiService
}