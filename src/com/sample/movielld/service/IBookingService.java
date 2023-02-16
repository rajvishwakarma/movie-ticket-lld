package com.sample.movielld.service;

import com.sample.movielld.entities.Booking;
import com.sample.movielld.request.BookingRequest;
import com.sample.movielld.responses.TicketResponse;

public interface IBookingService {

	Booking bookTicket(BookingRequest bookingRequest);

	TicketResponse getTicket(String id);

	Booking saveBooking(Booking booking);

}
