package com.example.retrofit100.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.retrofit100.R;
import com.example.retrofit100.model.MovieModel;

import java.util.List;

public class MovieListAdapter extends RecyclerView.Adapter<MovieListAdapter.MyViewHolder> {

    private Context context;
    private List<MovieModel> movieList;

    public MovieListAdapter(Context context, List<MovieModel> movieList) {
        this.context = context;
        this.movieList = movieList;
    }



    public void setMovieList(){
        this.movieList=movieList;
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view=LayoutInflater.from(context).inflate(R.layout.recycler_row,parent,false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.tvTitle.setText(this.movieList.get(position).getTitle().toString());
        Glide.with(context).load(this.movieList.get(position).getImage())
                .apply(RequestOptions.centerCropTransform())
                .into(holder.imageView);
    }

    @Override
    public int getItemCount() {
        return movieList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        TextView tvTitle;
        ImageView imageView;
        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTitle=itemView.findViewById(R.id.titleView);
            imageView=itemView.findViewById(R.id.imageView);
        }
    }
}
