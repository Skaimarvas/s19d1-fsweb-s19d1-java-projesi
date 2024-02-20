package com.example.s19d1.service;

import com.example.s19d1.entity.Movie;

import java.util.List;

public interface MovieService {
    List<Movie> findAll();

    Movie findById(int id);

    Movie save(Movie movie);

    Movie delete(int id);

    Movie update(int id, Movie movie);

}
