package com.jindal.movieview.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.jindal.movieview.model.movie.MoviesModel
import com.jindal.movieview.network.APIService

class MoviesRepository( private val api:APIService) {

    private val liveData = MutableLiveData<MoviesModel>()

    val moviedata: LiveData<MoviesModel>
        get() = liveData

    suspend fun getData() {
        val result = api.getMovies();
        if (result?.body() != null) {
            liveData.postValue(result.body())
            println("Movie is"+result.body())
        }
    }

}