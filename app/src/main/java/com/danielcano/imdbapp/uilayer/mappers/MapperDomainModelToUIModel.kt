package com.danielcano.imdbapp.uilayer.mappers

import com.danielcano.imdbapp.domainlayer.models.MovieModel
import com.danielcano.imdbapp.uilayer.models.MovieUIModel

class MapperDomainModelToUIModel() {
    private val imgUrlBase = "https://image.tmdb.org/t/p/w500"

    fun convertData(entityData: List<MovieModel>): List<MovieUIModel> {
        val convertedData = mutableListOf<MovieUIModel>()

        entityData.forEach { entityMovie ->
            convertedData.add(
                MovieUIModel(
                    name = entityMovie.name,
                    nameEs = entityMovie.nameEs,
                    year = entityMovie.year,
                    actors = "",
                    rating = entityMovie.rating,
                    thumbnail = entityMovie.thumbnail,
                    category = "Movie",
                    numberEpisodes = 1,
                    synopsis = entityMovie.synopsis,
                    preview = entityMovie.preview
                )
            )
        }
        return convertedData
    }

}