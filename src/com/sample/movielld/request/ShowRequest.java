package com.sample.movielld.request;

import java.util.Date;
import java.util.Map;

import com.sample.movielld.entities.Movie;
import com.sample.movielld.entities.Theatre;
import com.sample.movielld.enums.SeatStatus;

public class ShowRequest {
	
	private Date startTS;
	private long durationInMin;
	private String theatreId;
	private Movie movie;
	private Map<String, SeatStatus> seats;
	
	public ShowRequest(Date startTS, long durationInMin, String theatreId, Movie movie, Map<String, SeatStatus> seats) {
		this.startTS = startTS;
		this.durationInMin = durationInMin;
		this.theatreId = theatreId;
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

	public String getTheatreId() {
		return theatreId;
	}

	public void setTheatreId(String theatreId) {
		this.theatreId = theatreId;
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
