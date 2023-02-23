package com.danielcano.imdbapp.datalayer.datasources.network

import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET

const val BASE_URL = "https://api.themoviedb.org/3/"
const val API_KEY = "c5c47722a4adcc77f6e84f28a48b857a"

interface MoviesApiService {
    @GET("movie/top_rated?api_key=${API_KEY}&language=es")
    suspend fun getTopRatedMovies(): TopRatedMoviesEndPointResponse

    @GET("list/1?api_key=${API_KEY}&language=es")
    suspend fun getListOfMovies(): ListOfMoviesEndPointResponse
}

private val moshi = Moshi.Builder()
    .add(KotlinJsonAdapterFactory())
    .build()

private val retrofit = Retrofit.Builder()
    .addConverterFactory(MoshiConverterFactory.create(moshi))
    .baseUrl(BASE_URL)
    .build()

object MoviesApi {
    val retrofitService: MoviesApiService by lazy {
        retrofit.create(MoviesApiService::class.java)
    }
}