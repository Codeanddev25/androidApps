package com.jindal.movieview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.jindal.movieview.adapter.MovieListAdapter;
import com.jindal.movieview.model.movie.MoviesModel;
import com.jindal.movieview.model.movie.Result;
import com.jindal.movieview.network.APIService;
import com.jindal.movieview.network.RetrofitHelper;
import com.jindal.movieview.viewmodel.MoviesViewModel;
import com.jindal.movieview.viewmodel.ViewModelFactory;

import java.util.ArrayList;
import java.util.List;
import java.util.Observer;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerview;
    MoviesViewModel viewModel;
    MovieListAdapter adapter;
    List<Result> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        list = new ArrayList<>();

        recyclerview = findViewById(R.id.recyclerview);
        adapter = new MovieListAdapter(this,list);
        recyclerview.setLayoutManager(new LinearLayoutManager(this));
        recyclerview.setAdapter(adapter);

        viewModel = new ViewModelProvider(this, new ViewModelFactory(RetrofitHelper.INSTANCE.getInstance().create(APIService.class))).get(MoviesViewModel.class);
        viewModel.getMovies();

        viewModel.getMoviedata().observe(this,movieData -> {
            list.addAll(movieData.getResults());
            adapter.notifyDataSetChanged();
        });

    }
}