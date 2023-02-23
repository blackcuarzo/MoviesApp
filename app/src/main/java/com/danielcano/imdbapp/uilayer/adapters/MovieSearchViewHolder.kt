package com.danielcano.imdbapp.uilayer.adapters

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.danielcano.imdbapp.databinding.ItemSearchMovieBinding
import com.danielcano.imdbapp.domainlayer.models.MovieModel

class MovieSearchViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
    private val binding = ItemSearchMovieBinding.bind(itemView)

    fun bind(movie: MovieModel) {
        binding.movieNameText.text = movie.name
        binding.movieActorsText.text = movie.actors
        binding.movieYearText.text = movie.year
        binding.movieThumbnailImage.load(movie.thumbnail)
    }
}