package com.sample.movielld.service;

import java.util.List;

import com.sample.movielld.entities.Movie;

public interface IMovieService {

	Movie addMovie(Movie m1);

	List<Movie> findAll();


}
