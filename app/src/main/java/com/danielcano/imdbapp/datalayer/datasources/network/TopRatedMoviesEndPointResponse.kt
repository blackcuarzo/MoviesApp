package com.danielcano.imdbapp.datalayer.datasources.network

import com.squareup.moshi.Json

data class TopRatedMoviesEndPointResponse(
    @Json(name = "results")
    val results: List<MovieNetworkDto>
)

