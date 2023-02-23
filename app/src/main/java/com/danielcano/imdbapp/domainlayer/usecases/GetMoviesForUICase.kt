package com.danielcano.imdbapp.domainlayer.usecases

import com.danielcano.imdbapp.domainlayer.models.MovieModel

interface GetMoviesForUICase {
    suspend fun getMovies(): List<MovieModel>
}