package com.danielcano.imdbapp.datalayer.repositories

import com.danielcano.imdbapp.domainlayer.models.MovieModel

interface MoviesRepository {
    suspend fun getMovies(): List<MovieModel>
}