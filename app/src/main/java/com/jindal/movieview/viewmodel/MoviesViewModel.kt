package com.jindal.movieview.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jindal.movieview.model.movie.MoviesModel
import com.jindal.movieview.network.APIService
import com.jindal.movieview.repository.MoviesRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MoviesViewModel(private val api: APIService)  : ViewModel()  {
    private val repository = MoviesRepository(api);

    val moviedata: LiveData<MoviesModel>
        get() = repository.moviedata

    fun getMovies() {
        viewModelScope.launch(Dispatchers.IO) {
            repository.getData()
        }
    }


}