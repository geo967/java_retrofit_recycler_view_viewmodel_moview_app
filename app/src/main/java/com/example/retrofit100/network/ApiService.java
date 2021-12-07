package com.example.retrofit100.network;

import com.example.retrofit100.model.MovieModel;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("volley_array.json")
    Call<List<MovieModel>> getMovieList();
}
