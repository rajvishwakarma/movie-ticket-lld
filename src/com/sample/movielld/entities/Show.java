package com.sample.movielld.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.UUID;

import com.sample.movielld.enums.SeatStatus;

public class Show {
	
	private String id;
	private Date startTS;
	private long durationInMin;
	private Theatre theatre;//mapping
	private Movie movie;
	private Map<String, SeatStatus> seats;
	
	public Show(Date startTS, long durationInMin) {
		this.id = UUID.randomUUID().toString();
		this.startTS = startTS;
		this.durationInMin = durationInMin;
		this.seats = new HashMap<>();
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
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

	public Movie getMovie() {
		return movie;
	}

	public void setMovie(Movie movie) {
		this.movie = movie;
	}

	public void addSeats(Map<String, SeatStatus> seats) {
		this.seats.putAll(seats);
	}

	public Theatre getTheatre() {
		return theatre;
	}

	public void setTheatre(Theatre theatre) {
		this.theatre = theatre;
	}

	public Map<String, SeatStatus> getSeats() {
		return seats;
	}

	public void setSeats(Map<String, SeatStatus> seats) {
		this.seats = seats;
	}

	@Override
	public String toString() {
		return "Show [id=" + id + ", startTS=" + startTS + ", durationInMin=" + durationInMin + ", theatre=" + theatre
				+ ", movie=" + movie + ", seats=" + seats + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Show other = (Show) obj;
		return Objects.equals(id, other.id);
	}
	
	
}
