package com.danielcano.imdbapp.datalayer.datasources.network

class TopRatedMoviesNetworkDataSourceImpl : MoviesNetworkDataSource {
    override suspend fun getMovies(): List<MovieNetworkDto> {
        return MoviesApi.retrofitService.getTopRatedMovies().results
    }
}