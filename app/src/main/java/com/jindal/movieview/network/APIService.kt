package com.jindal.movieview.network

import com.jindal.movieview.model.movie.MoviesModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

interface APIService {

    @Headers(
        value = ["content-type: application/json",
            "X-RapidAPI-Host: movies-app1.p.rapidapi.com",
            "X-RapidAPI-Key: 76e65b2b17msh0c706c7e7bdfca9p18cb62jsn3863dc894787"]
    )
    @GET("/api/movies")
    suspend fun getMovies(): retrofit2.Response<MoviesModel>
}