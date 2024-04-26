package com.example.themovie.data.model

import com.example.themovie.data.model.MovieModel
import com.google.gson.annotations.SerializedName

data class MovieResult(
    @SerializedName("results")
    val results: List<MovieModel>
)