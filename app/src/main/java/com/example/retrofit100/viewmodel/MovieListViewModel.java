package com.example.retrofit100.viewmodel;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.retrofit100.model.MovieModel;
import com.example.retrofit100.network.ApiService;
import com.example.retrofit100.network.RetroInstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.internal.EverythingIsNonNull;

public class MovieListViewModel extends ViewModel {

    private MutableLiveData<List<MovieModel>> moviesList;
    public MovieListViewModel() {
        moviesList=new MutableLiveData<>();
    }
    public MutableLiveData<List<MovieModel>> getMoviesListObserver(){
        return moviesList;
    }
    public void makeApiCall(){
        ApiService apiService= RetroInstance.getRetroClient().create(ApiService.class);
        Call<List<MovieModel>> call=apiService.getMovieList();

        call.enqueue(new Callback<List<MovieModel>>() {
            @Override
            @EverythingIsNonNull
            public void onResponse(Call<List<MovieModel>> call, Response<List<MovieModel>> response) {
                moviesList.postValue(response.body());
            }

            @Override
            @EverythingIsNonNull
            public void onFailure(Call<List<MovieModel>> call, Throwable t) {
                moviesList.postValue(null);
            }
        });
    }
}
