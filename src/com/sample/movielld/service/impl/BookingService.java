package com.sample.movielld.service.impl;

import com.sample.movielld.entities.Booking;
import com.sample.movielld.entities.Show;
import com.sample.movielld.entities.Theatre;
import com.sample.movielld.enums.BookingStatus;
import com.sample.movielld.enums.SeatStatus;
import com.sample.movielld.exception.SeatAlreadyBookException;
import com.sample.movielld.request.BookingRequest;
import com.sample.movielld.responses.TicketResponse;
import com.sample.movielld.service.IBookingService;
import com.sample.movielld.service.IShowService;
import com.sample.movielld.service.IStorageService;
import com.sample.movielld.service.ITheatreService;

public class BookingService implements IBookingService{
	
	IStorageService storageService;
	ITheatreService theatreService;
	IShowService showService;
	
	public BookingService(IStorageService storageService, ITheatreService theatreService, IShowService showService) {
		this.storageService = storageService;
		this.showService = showService;
		this.theatreService = theatreService;
	}

	@Override
	public Booking bookTicket(BookingRequest bookingRequest) {
		
		Show show = showService.findById(bookingRequest.getShow().getId());
		if(null != show) {
			for (String seat : bookingRequest.getSeats()) {
				if(show.getSeats().containsKey(seat) && show.getSeats().get(seat).equals(SeatStatus.BOOKED))
					throw new SeatAlreadyBookException();
			}
			
			Booking booking = new Booking(show, bookingRequest.getUser(), bookingRequest.getSeats());
			
			for (String seat : bookingRequest.getSeats()) {
				show.getSeats().put(seat, SeatStatus.BOOKED);
			}
			show = showService.saveShow(show);
			
			Theatre theatre = theatreService.findById(show.getTheatreId());
			theatre.addShow(show);
			theatreService.saveTheatre(theatre);
			
			booking.updateStatus(BookingStatus.PENDING_FOR_PAYMENT);
			booking = storageService.saveBooking(booking);
			return booking;
		}
		return null;
	}

	@Override
	public TicketResponse getTicket(String id) {
		Booking booking = storageService.getBooking(id);
		Theatre theatre = theatreService.findById(booking.getShow().getTheatreId());
		
		return new TicketResponse(booking.getId(), booking.getShow().getStartTS(), booking.getShow().getDurationInMin(), 
				theatre.getName(), theatre.getCity(), booking.getShow().getMovie().getName(), booking.getSeats(), 
				booking.getBookingTime());
	}

	@Override
	public Booking saveBooking(Booking booking) {
		return storageService.saveBooking(booking);
	}
}
