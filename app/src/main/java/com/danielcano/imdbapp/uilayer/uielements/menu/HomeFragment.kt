package com.danielcano.imdbapp.uilayer.uielements.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.danielcano.imdbapp.databinding.FragmentHomeBinding
import com.danielcano.imdbapp.domainlayer.models.MovieModel
import com.danielcano.imdbapp.uilayer.adapters.MovieRecommendationListAdapter
import com.danielcano.imdbapp.uilayer.viewmodels.HomeViewModel

class HomeFragment : Fragment() {

    private val viewModel by viewModels<HomeViewModel>()
    private var _binding: FragmentHomeBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentHomeBinding.inflate(inflater, container, false)
        val view = binding.root
        val movieList: RecyclerView = binding.recomendationList
        movieList.layoutManager =
            LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
        val movieListAdapter = MovieRecommendationListAdapter(::showMovieDetails)
        movieList.adapter = movieListAdapter
        viewModel.movieList.observe(viewLifecycleOwner) { movieItemsList ->
            movieListAdapter.submitList(movieItemsList)
        }
        return view
    }

    private fun showMovieDetails(movie: MovieModel) {
        val action = HomeFragmentDirections.actionHomeFragmentToMovieDetailsFragment(
            name = movie.name,
            nameEs = movie.nameEs,
            synopsis = movie.synopsis,
            preview = movie.preview,
            thumbnail = movie.thumbnail,
            shortDescription = movie.synopsis,
            numberEpisodes = movie.numberEpisodes
        )
        findNavController().navigate(action)
    }
}