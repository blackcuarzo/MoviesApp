package com.danielcano.imdbapp.datalayer.datasources.network

import com.squareup.moshi.Json

data class ListOfMoviesEndPointResponse(
    @Json(name = "items")
    val items: List<MovieNetworkDto>
)

