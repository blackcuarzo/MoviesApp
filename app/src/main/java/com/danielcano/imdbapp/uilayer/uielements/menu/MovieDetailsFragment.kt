package com.danielcano.imdbapp.uilayer.uielements.menu

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.navigation.ui.setupWithNavController
import coil.load
import com.danielcano.imdbapp.databinding.FragmentMovieDetailsBinding

class MovieDetailsFragment : Fragment() {
    private val args: MovieDetailsFragmentArgs by navArgs()
    private var _binding: FragmentMovieDetailsBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentMovieDetailsBinding.inflate(inflater, container, false)
        val view = binding.root
        val navController = findNavController()
        val toolbar = binding.toolbar
        toolbar.setupWithNavController(navController)
        toolbar.title = args.name
        binding.nameEs.text = args.nameEs
        binding.name.text = args.name
        binding.synopsis.text = args.synopsis
        binding.previewImage.load(args.preview)
        binding.movieThumbnailImage.load(args.thumbnail)
        binding.movieThumbnailImage.load(args.thumbnail)
        return view
    }
}