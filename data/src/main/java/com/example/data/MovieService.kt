package com.example.data

import com.example.data.model.MovieResult
import retrofit2.Response
import retrofit2.http.GET

interface MovieService {
    @GET("movie/top_rated")
    suspend fun getTopRatedMovies(): Response<MovieResult>

}