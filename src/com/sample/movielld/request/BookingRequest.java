package com.sample.movielld.request;

import java.util.List;

import com.sample.movielld.entities.Show;
import com.sample.movielld.entities.User;

public class BookingRequest {
	private Show show;
	private List<String> seats;
	private User user;
	
	public BookingRequest(Show show, List<String> seats, User user) {
		this.show = show;
		this.seats = seats;
		this.user = user;
	}

	public Show getShow() {
		return show;
	}

	public void setShow(Show show) {
		this.show = show;
	}

	public List<String> getSeats() {
		return seats;
	}

	public void setSeats(List<String> seats) {
		this.seats = seats;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
}
