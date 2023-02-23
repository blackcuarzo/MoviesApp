package com.danielcano.imdbapp.datalayer.datasources.network

import com.squareup.moshi.Json

data class MovieNetworkDto(
    val title: String,
    @Json(name = "original_title")
    val originalTitle: String,
    @Json(name = "release_date")
    val releaseDate: String,
    @Json(name = "vote_average")
    val voteAverage: Float,
    val overview: String,
    @Json(name = "backdrop_path")
    val backdropPath: String,
    @Json(name = "poster_path")
    val posterPath: String
)