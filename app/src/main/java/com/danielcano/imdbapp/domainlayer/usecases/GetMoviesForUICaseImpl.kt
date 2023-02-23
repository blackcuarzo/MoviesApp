package com.danielcano.imdbapp.domainlayer.usecases

import com.danielcano.imdbapp.datalayer.repositories.MoviesRepository
import com.danielcano.imdbapp.domainlayer.models.MovieModel

class GetMoviesForUICaseImpl(private val repository: MoviesRepository) : GetMoviesForUICase {
    override suspend fun getMovies(): List<MovieModel> {
        return repository.getMovies()
    }
}