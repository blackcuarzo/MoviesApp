package com.danielcano.imdbapp.uilayer.models

data class MovieUIModel(
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