package com.danielcano.imdbapp.uilayer.viewmodels

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.danielcano.imdbapp.datalayer.datasources.network.TopRatedMoviesNetworkDataSourceImpl
import com.danielcano.imdbapp.datalayer.repositories.MoviesRepositoryImpl
import com.danielcano.imdbapp.domainlayer.models.MovieModel
import com.danielcano.imdbapp.domainlayer.usecases.GetMoviesForUICase
import com.danielcano.imdbapp.domainlayer.usecases.GetMoviesForUICaseImpl
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {
    private val _movieList = MutableLiveData<List<MovieModel>>()
    val movieList: LiveData<List<MovieModel>> = _movieList
    private val topRatedPointUseCase =
        GetMoviesForUICaseImpl(MoviesRepositoryImpl(TopRatedMoviesNetworkDataSourceImpl()))

    init {
        loadMovies(topRatedPointUseCase)
    }

    private fun loadMovies(useCase: GetMoviesForUICase) {
        viewModelScope.launch {
            try {
                _movieList.value = useCase.getMovies()
            } catch (e: Exception) {
                _movieList.value = listOf()
            }
        }
    }
}