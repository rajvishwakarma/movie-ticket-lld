package com.sample.movielld.service.impl;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import java.util.stream.Collectors;

import com.sample.movielld.entities.Booking;
import com.sample.movielld.entities.Movie;
import com.sample.movielld.entities.Show;
import com.sample.movielld.entities.Theatre;
import com.sample.movielld.entities.User;
import com.sample.movielld.service.IStorageService;

public class StorageService implements IStorageService {
	
	private static StorageService instance = null;
	
	
	private Map<String, User> userMap = null;
	private Map<String, Theatre> theatreMap = null;
	private Map<String, Show> showMap = null;
	private Map<String, Movie> movieMap = null;
	private Map<String, Booking> bookingMap = null;
	private Map<String, List<Show>> movieShow = null;
	
	
	private StorageService() {
		this.userMap = new HashMap<>();
		this.theatreMap = new HashMap<>();
		this.showMap = new HashMap<>();
		this.movieMap = new HashMap<>();
		this.bookingMap = new HashMap<>();
		this.movieShow = new HashMap<>();
	}
	
	public static synchronized StorageService getInstance() {
		//synchronized (instance) {
			if(null == instance) {
				instance = new StorageService();
			}
		//}
		return instance;
	}

	@Override
	public User saveUser(User u1) {
		this.userMap.put(u1.getId(), u1);
		return this.userMap.get(u1.getId());
	}

	@Override
	public User getUser(long id) {
		return this.userMap.get(id);
	}

	@Override
	public Theatre saveTheatre(Theatre theatre1) {
		this.theatreMap.put(theatre1.getId(), theatre1);
		return this.theatreMap.get(theatre1.getId());
	}

	@Override
	public Movie saveMovie(Movie m) {
		
		this.movieMap.put(m.getId(), m);
		return this.movieMap.get(m.getId());
	}

	@Override
	public Show saveShow(Show show1) {
		
		if(this.movieShow.containsKey(show1.getMovie().getName())) {
			this.movieShow.get(show1.getMovie().getName()).add(show1);
		} else
			this.movieShow.put(show1.getMovie().getName(), new ArrayList<>() {{ add(show1);}});
		
		this.showMap.put(show1.getId(), show1);
		return this.showMap.get(show1.getId());
	}

	@Override
	public List<Show> findShows(String movieSearchTerm) {
		return movieShow.containsKey(movieSearchTerm) ? this.movieShow.get(movieSearchTerm) : Collections.EMPTY_LIST;
	}

	@Override
	public Show findShowById(String id) {
		return showMap.get(id);
	}

	@Override
	public Booking saveBooking(Booking booking) {
		booking.setId(UUID.randomUUID().toString());
		this.bookingMap.put(booking.getId(), booking);
		return this.bookingMap.get(booking.getId());
	}

	@Override
	public Booking getBooking(String id) {
		return this.bookingMap.get(id);
	}

	@Override
	public List<Theatre> findAllTheatres() {
		return this.theatreMap.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
	}

	@Override
	public List<Movie> findAllMovies() {
		return this.movieMap.entrySet().stream().map(entry -> entry.getValue()).collect(Collectors.toList());
	}

	@Override
	public Theatre findTheatreById(String theatreId) {
		return this.theatreMap.get(theatreId);
	}
	
	
}
