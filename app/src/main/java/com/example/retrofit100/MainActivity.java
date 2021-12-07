package com.example.retrofit100;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.LayoutInflater;

import com.example.retrofit100.adapter.MovieListAdapter;
import com.example.retrofit100.model.MovieModel;
import com.example.retrofit100.viewmodel.MovieListViewModel;

import java.time.DayOfWeek;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<MovieModel> movieModelList;
    private MovieListAdapter adapter;
    private MovieListViewModel viewModel;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        LinearLayoutManager layoutManager=new GridLayoutManager(this,2);
        recyclerView.setLayoutManager(layoutManager);
        MovieListAdapter adapter=new MovieListAdapter(this,);
        recyclerView.setAdapter(adapter);

        viewModel= ViewModelProvider.of(this).get(MovieListViewModel.class);
    }
}