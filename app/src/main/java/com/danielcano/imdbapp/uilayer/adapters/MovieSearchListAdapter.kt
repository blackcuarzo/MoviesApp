package com.danielcano.imdbapp.uilayer.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.domainlayer.models.MovieModel

class MovieSearchListAdapter(private val clickHandler: (MovieModel) -> Unit) :
    ListAdapter<MovieModel, MovieSearchViewHolder>(
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

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieSearchViewHolder {
        val itemView =
            LayoutInflater.from(parent.context)
                .inflate(R.layout.item_search_movie, parent, false)
        return MovieSearchViewHolder(itemView)
    }

    override fun onBindViewHolder(holder: MovieSearchViewHolder, position: Int) {
        val movie = getItem(position)
        holder.bind(movie)
        holder.itemView.setOnClickListener {
            clickHandler(movie)
        }
    }

}