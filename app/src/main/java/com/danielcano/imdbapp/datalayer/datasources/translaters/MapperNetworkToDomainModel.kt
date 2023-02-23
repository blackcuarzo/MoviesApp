package com.danielcano.imdbapp.datalayer.datasources.translaters

import com.danielcano.imdbapp.datalayer.datasources.network.MovieNetworkDto
import com.danielcano.imdbapp.domainlayer.models.MovieModel

class MapperNetworkToDomainModel () {
    private val imgUrlBase = "https://image.tmdb.org/t/p/w500"

    fun convertData(remoteData:List<MovieNetworkDto>):List<MovieModel>{
        val convertedData = mutableListOf<MovieModel>()

        remoteData.forEach{
                remoteMovie -> convertedData.add(
                    MovieModel(
                        name = remoteMovie.originalTitle,
                        nameEs = remoteMovie.title,
                        year = remoteMovie.releaseDate,
                        actors = "placeholder",
                        rating = remoteMovie.voteAverage,
                        thumbnail = imgUrlBase + remoteMovie.posterPath,
                        category = "Movie",
                        numberEpisodes = 1,
                        synopsis = remoteMovie.overview,
                        preview = imgUrlBase + remoteMovie.backdropPath
                    )
                )
        }
        return convertedData
    }

}