package com.danielcano.imdbapp.datalayer.datasources

interface MoviesLocalDataSource {
    suspend fun getMoviesList():List<MovieDtoLocal>
}