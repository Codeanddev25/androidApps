package com.jindal.movieview.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.jindal.movieview.network.APIService

class ViewModelFactory(private val api: APIService):ViewModelProvider.Factory {
        override fun <T : ViewModel> create(modelClass: Class<T>): T {
            return MoviesViewModel(api) as T
        }
    }
