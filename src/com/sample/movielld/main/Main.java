package com.sample.movielld.main;

import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.sample.movielld.entities.Booking;
import com.sample.movielld.entities.Movie;
import com.sample.movielld.entities.Show;
import com.sample.movielld.entities.Theatre;
import com.sample.movielld.entities.User;
import com.sample.movielld.enums.BookingStatus;
import com.sample.movielld.enums.SeatStatus;
import com.sample.movielld.request.BookingRequest;
import com.sample.movielld.request.ShowRequest;
import com.sample.movielld.responses.TicketResponse;
import com.sample.movielld.service.IBookingService;
import com.sample.movielld.service.IMovieService;
import com.sample.movielld.service.ISearchService;
import com.sample.movielld.service.IShowService;
import com.sample.movielld.service.IStorageService;
import com.sample.movielld.service.ITheatreService;
import com.sample.movielld.service.IUserService;
import com.sample.movielld.service.impl.BookingService;
import com.sample.movielld.service.impl.MovieService;
import com.sample.movielld.service.impl.SearchService;
import com.sample.movielld.service.impl.ShowService;
import com.sample.movielld.service.impl.StorageService;
import com.sample.movielld.service.impl.TheatreService;
import com.sample.movielld.service.impl.UserService;

public class Main {
	public static void main(String[] args) {
		
		IStorageService storageService = StorageService.getInstance();
		IUserService userService = new UserService(storageService);
		ITheatreService theatreService = new TheatreService(storageService);
		IMovieService movieService = new MovieService(storageService);
		IShowService showService = new ShowService(storageService, theatreService);
		IBookingService bookingService = new BookingService(storageService, theatreService, showService);
		ISearchService searchService = new SearchService(storageService);
		
		//User registers
		User user1 = new User("XYZ");
		user1 = userService.addUser(user1);
		System.out.println("User Created: " + user1);
		
		//Theatre Added
		Theatre theatre1 = new Theatre("PVR", "Mumbai");
		theatre1 = theatreService.saveTheatre(theatre1);
		Theatre theatre2 = new Theatre("Maxus", "Mumbai");
		theatre2 = theatreService.saveTheatre(theatre2);
		
		System.out.println("List Theatres: " + theatreService.findAll());
		
		//Movie Added
		Movie m1 = new Movie("ABC", "HINDI", "Some Info");
		Movie m2 = new Movie("XYZ", "HINDI", "Some Info");
		m1 = movieService.addMovie(m1);
		m2 = movieService.addMovie(m2);
		
		System.out.println("List Movies: " + movieService.findAll());
		
		//Seats created
		Map<String, SeatStatus> seats = new HashMap<>();
		seats.put("A1", SeatStatus.VACANT); //Here A stands for row with seat no 1
		seats.put("A2", SeatStatus.VACANT);
		seats.put("A3", SeatStatus.VACANT);
		seats.put("A4", SeatStatus.VACANT);
		
		seats.put("B1", SeatStatus.VACANT);
		seats.put("B2", SeatStatus.VACANT);
		seats.put("B3", SeatStatus.VACANT);
		seats.put("B4", SeatStatus.VACANT);
		
		
		//Theatre will create Show for a movie and Add Seats
		ShowRequest request1 = new ShowRequest(Date.from(LocalDateTime.of(2023, 02, 16, 10, 0).toInstant(ZoneOffset.UTC.ofHoursMinutes(5, 30))), 60, 
				theatre1.getId(), m1, seats);
		Show show1 = showService.createShow(request1);
		
		ShowRequest request2 = new ShowRequest(Date.from(LocalDateTime.of(2023, 02, 16, 14, 0).toInstant(ZoneOffset.UTC.ofHoursMinutes(5, 30))), 60, 
				theatre2.getId(), m1, seats);
		Show show2 = showService.createShow(request2);
		
		//Add shows to Theatre
		theatre1.addShow(show1);
		theatre1.addShow(show2);
		theatre1 = theatreService.saveTheatre(theatre1);
		theatre2 = theatreService.saveTheatre(theatre2);
		
		System.out.println("List Theatres: " + theatreService.findAll());
		
		//Search movie based on name
		//Here, there is no check on showtime. That needs to be done.
		String movieSearchTerm = "ABC";
		List<Show> shows = searchService.findShows(movieSearchTerm);
		System.out.println("List Shows by Movie: " + shows);
		
		//selecting the show with seats
		Show selectedShow = shows.get(0);
		//Filtering the VACANCT seats
		List<String> availableSeats = selectedShow.getSeats().entrySet().stream().filter(entry -> entry.getValue().equals(SeatStatus.VACANT)) 
				.map(entry -> entry.getKey()).collect(Collectors.toList());
		List<String> selectedSeats = new ArrayList<>();
		selectedSeats.add(availableSeats.get(0));
		
		BookingRequest bookingRequest = new BookingRequest(selectedShow, selectedSeats, user1);
		Booking booking = bookingService.bookTicket(bookingRequest);
		
		//Have Logic for Payment.
		//Here We can introduced locks on seat where the selected seats get locked for some time and if the payment is
		//not completed then the same seats would be available to the other users.
		
		//Here were assuming that the payment is done.
		booking.updateStatus(BookingStatus.COMPLETED);
		booking = bookingService.saveBooking(booking);
		System.out.println("Booking Details: " + booking);
		
		//Print Ticket
		TicketResponse ticket = bookingService.getTicket(booking.getId());
		System.out.println("Here is the Ticket: " + ticket.toString());
	}
}
