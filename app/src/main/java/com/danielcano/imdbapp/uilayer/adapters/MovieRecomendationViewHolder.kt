package com.danielcano.imdbapp.uilayer.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.danielcano.imdbapp.databinding.ItemRecomendationMovieBinding
import com.danielcano.imdbapp.domainlayer.models.MovieModel

class MovieRecomendationViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    val binding = ItemRecomendationMovieBinding.bind(itemView)

    fun bind(movie: MovieModel) {
        binding.movieNameText.text = movie.name
        binding.movieThumbnailImage.load(movie.thumbnail)
    }
}