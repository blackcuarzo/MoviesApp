package com.danielcano.imdbapp.datalayer.datasources.network

class ListOfMoviesNetworkDataSourceImpl : MoviesNetworkDataSource {
    override suspend fun getMovies(): List<MovieNetworkDto> {
        return MoviesApi.retrofitService.getListOfMovies().items
    }
}