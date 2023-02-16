package com.sample.movielld.request;

import java.util.Date;
import java.util.Map;

import com.sample.movielld.entities.Movie;
import com.sample.movielld.entities.Theatre;
import com.sample.movielld.enums.SeatStatus;

public class ShowRequest {
	
	private Date startTS;
	private long durationInMin;
	private Theatre theatre;
	private Movie movie;
	private Map<String, SeatStatus> seats;
	
	public ShowRequest(Date startTS, long durationInMin, Theatre theatre, Movie movie, Map<String, SeatStatus> seats) {
		this.startTS = startTS;
		this.durationInMin = durationInMin;
		this.theatre = theatre;
		this.movie = movie;
		this.seats = seats;
	}

	public Date getStartTS() {
		return startTS;
	}

	public void setStartTS(Date startTS) {
		this.startTS = startTS;
	}

	public long getDurationInMin() {
		return durationInMin;
	}

	public void setDurationInMin(long durationInMin) {
		this.durationInMin = durationInMin;
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public Map<String, SeatStatus> getSeats() {
		return seats;
	}

	public void setSeats(Map<String, SeatStatus> seats) {
		this.seats = seats;
	}
	
	
}
