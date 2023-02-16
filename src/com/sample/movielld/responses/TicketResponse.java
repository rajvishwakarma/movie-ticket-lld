package com.sample.movielld.responses;

import java.util.Date;
import java.util.List;

public class TicketResponse {
		
	private String id;
	private Date showTime;
	private long durationInMin;
	private String theatre;
	private String location;
	private String movie;
	private List<String> seats;
	private Date bookingTime;
	
	public TicketResponse(String id, Date showTime, long durationInMin, String theatre, String location, String movie,
			List<String> seats, Date bookingTime) {
		this.id = id;
		this.showTime = showTime;
		this.durationInMin = durationInMin;
		this.theatre = theatre;
		this.location = location;
		this.movie = movie;
		this.seats = seats;
		this.bookingTime = bookingTime;
	}

	@Override
	public String toString() {
		return "TicketResponse [id=" + id + ", showTime=" + showTime + ", durationInMin=" + durationInMin + ", theatre="
				+ theatre + ", location=" + location + ", movie=" + movie + ", seats=" + seats + ", bookingTime="
				+ bookingTime + "]";
	}
	
}
