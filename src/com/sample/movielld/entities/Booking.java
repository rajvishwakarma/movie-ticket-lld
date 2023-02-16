package com.sample.movielld.entities;

import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.UUID;

import com.sample.movielld.enums.BookingStatus;

public class Booking {
	
	private String id;
	private Show show;
	private User user;
	private List<String> seats;
	private BookingStatus status;
	private Date bookingTime;
	
	public Booking(Show show, User user, List<String> seats) {
		this.id = UUID.randomUUID().toString();
		this.show = show;
		this.user = user;
		this.seats = seats;
		this.status = BookingStatus.CREATED;
		this.bookingTime = new Date();
	}
	
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	
	public Show getShow() {
		return show;
	}
	public void setShow(Show show) {
		this.show = show;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public List<String> getSeats() {
		return seats;
	}
	public void setSeats(List<String> seats) {
		this.seats = seats;
	}
	public BookingStatus getStatus() {
		return status;
	}
	public void setStatus(BookingStatus status) {
		this.status = status;
	}
	public void updateStatus(BookingStatus status) {
		this.status = status;
	}
	
	public Date getBookingTime() {
		return bookingTime;
	}
	public void setBookingTime(Date bookingTime) {
		this.bookingTime = bookingTime;
	}
	@Override
	public String toString() {
		return "Booking [id=" + id + ", show=" + show + ", user=" + user + ", seats=" + seats + ", status=" + status
				+ "]";
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
		Booking other = (Booking) obj;
		return Objects.equals(id, other.id);
	}
	
}
