package com.sample.movielld.service.impl;

import java.util.List;

import com.sample.movielld.entities.Movie;
import com.sample.movielld.service.IMovieService;
import com.sample.movielld.service.IStorageService;

public class MovieService implements IMovieService {
	
	IStorageService storageService;

	public MovieService(IStorageService storageService) {
		this.storageService = storageService;
	}

	@Override
	public Movie addMovie(Movie m) {
		return this.storageService.saveMovie(m);
	}

	@Override
	public List<Movie> findAll() {
		return storageService.findAllMovies();
	}
}
