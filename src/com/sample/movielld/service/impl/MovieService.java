package com.sample.movielld.service.impl;

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
		return this.storageService.addMovie(m);
	}
}
