package com.danielcano.imdbapp.uilayer.uielements.menu

import android.content.Context.MODE_PRIVATE
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.danielcano.imdbapp.R
import com.danielcano.imdbapp.databinding.FragmentProfileBinding

class ProfileFragment : Fragment() {
    private var _binding: FragmentProfileBinding? = null
    private val binding get() = _binding!!


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        val reader = activity?.getSharedPreferences(getString(R.string.preferences), MODE_PRIVATE)
        _binding = FragmentProfileBinding.inflate(
            inflater, container, false
        )
        binding.userName.text = reader?.getString("userName", "Default name")

        // Inflate the layout for this fragment
        return binding.root
    }
}