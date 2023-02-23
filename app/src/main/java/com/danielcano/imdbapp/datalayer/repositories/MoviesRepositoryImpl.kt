package com.danielcano.imdbapp.datalayer.repositories

import com.danielcano.imdbapp.datalayer.datasources.network.MoviesNetworkDataSource
import com.danielcano.imdbapp.datalayer.datasources.translaters.MapperNetworkToDomainModel
import com.danielcano.imdbapp.domainlayer.models.MovieModel

class MoviesRepositoryImpl(private val datasource: MoviesNetworkDataSource) : MoviesRepository {

    override suspend fun getMovies(): List<MovieModel> {
        val moviesData = datasource.getMovies()
        return MapperNetworkToDomainModel().convertData(moviesData)
    }
}