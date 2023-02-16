package com.sample.movielld.service;

import java.util.List;

import com.sample.movielld.entities.Booking;
import com.sample.movielld.entities.Movie;
import com.sample.movielld.entities.Show;
import com.sample.movielld.entities.Theatre;
import com.sample.movielld.entities.User;

public interface IStorageService {

	User saveUser(User u1);

	User getUser(long id);

	Theatre saveTheatre(Theatre theatre1);

	Movie saveMovie(Movie m);

	Show saveShow(Show show1);

	List<Show> findShows(String movieSearchTerm);

	Show findShowById(String id);

	Booking saveBooking(Booking booking);

	Booking getBooking(String id);

	List<Theatre> findAllTheatres();

	List<Movie> findAllMovies();

	Theatre findTheatreById(String theatreId);

}
