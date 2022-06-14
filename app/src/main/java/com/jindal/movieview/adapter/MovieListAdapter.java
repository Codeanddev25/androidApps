package com.jindal.movieview.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.jindal.movieview.MainActivity;
import com.jindal.movieview.R;
import com.jindal.movieview.model.movie.MoviesModel;
import com.jindal.movieview.model.movie.Result;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {

    private Context context;
    private List<Result> list;


    public MovieListAdapter(Context context, List<Result> list){
        this.context = context;
        this.list = list;
    }


    @NonNull
    @Override
    public MovieListAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.recycler_row,parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MovieListAdapter.MyViewHolder holder, int position) {
        holder.tvTitle.setText(this.list.get(position).getTitle());
        Glide.with(context)
                .load(list.get(position).getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageView);

        holder.itemView.setOnClickListener(view -> {
            Toast.makeText(context, "Click", Toast.LENGTH_SHORT).show();
        });
    }

    @Override
    public int getItemCount() {
      return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder {
        TextView tvTitle;
        ImageView imageView;

        public MyViewHolder(View itemView){
            super(itemView);
            imageView = itemView.findViewById(R.id.imageView);
            tvTitle = itemView.findViewById(R.id.textTitle);
        }
    }
}
