package com.sample.movielld.service.impl;

import com.sample.movielld.entities.Show;
import com.sample.movielld.entities.Theatre;
import com.sample.movielld.request.ShowRequest;
import com.sample.movielld.service.IShowService;
import com.sample.movielld.service.IStorageService;
import com.sample.movielld.service.ITheatreService;

public class ShowService implements IShowService {
	
	IStorageService storageService;
	
	ITheatreService theatreService;

	public ShowService(IStorageService storageService, ITheatreService theatreService) {
		this.storageService = storageService;
		this.theatreService = theatreService;
	}

	@Override
	public Show saveShow(Show show1) {
		return storageService.saveShow(show1);
	}

	@Override
	public Show createShow(ShowRequest request) {
		Show show1 = new Show(request.getStartTS(), request.getDurationInMin());
		show1.setMovie(request.getMovie());
		show1.addSeats(request.getSeats());
		show1.setTheatreId(request.getTheatreId());
		show1 = saveShow(show1);
		
		Theatre theatre = theatreService.findById(request.getTheatreId());
		theatre.addShow(show1);
		theatreService.saveTheatre(theatre);
		return show1;
	}

	@Override
	public Show findById(String id) {
		return this.storageService.findShowById(id);
	}
}
