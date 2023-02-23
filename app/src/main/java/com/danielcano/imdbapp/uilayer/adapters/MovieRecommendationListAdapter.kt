package com.danielcano.imdbapp.uilayer.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.domainlayer.models.MovieModel

class MovieRecommendationListAdapter(private val clickHandler: (MovieModel) -> Unit) :
    ListAdapter<MovieModel, MovieRecomendationViewHolder>(
        MovieDiffCallback
    ) {
    object MovieDiffCallback : DiffUtil.ItemCallback<MovieModel>() {
        override fun areItemsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: MovieModel, newItem: MovieModel): Boolean {
            return oldItem == newItem
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieRecomendationViewHolder {
        val itemView =
            LayoutInflater.from(parent.context).inflate(R.layout.item_recomendation_movie, parent, false)
        return MovieRecomendationViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieRecomendationViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            clickHandler(movie)
        }
    }

}