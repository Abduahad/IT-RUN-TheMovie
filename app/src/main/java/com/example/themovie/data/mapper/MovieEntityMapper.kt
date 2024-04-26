package com.example.themovie.data.mapper

import com.example.themovie.data.model.MovieModel
import com.example.themovie.data.model.MovieResult
import com.example.themovie.domain.model.MovieEntity

class MovieEntityMapper : (MovieResult) -> List<MovieEntity> {
    fun map(movieModel: MovieModel): MovieEntity {
        return MovieEntity(
            id = movieModel.id,
            name = if (movieModel.originalTitle.isNullOrEmpty()) movieModel.originalName else movieModel.originalTitle,
            poster = movieModel.posterPath
        )
    }

    override fun invoke(movies: MovieResult): List<MovieEntity> {
        return movies.results.map { map(it) }
    }
}