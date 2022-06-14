package com.jindal.movieview.model.movie

data class MoviesModel(
    val messageStatus: String,
    val results: List<Result>,
    val status: Int,
    val success: Boolean,
    val total_pages: Int,
    val total_results: Int
)