package com.danielcano.imdbapp.domainlayer.models

data class MovieModel(
    val name: String,
    val nameEs: String,
    val year: String,
    val actors: String,
    val rating: Float,
    val thumbnail: String,
    val synopsis: String,
    val preview: String,
    val numberEpisodes: Int,
    val category: String,
)