package com.sample.movielld.service.impl;

import java.util.List;

import com.sample.movielld.entities.Theatre;
import com.sample.movielld.service.IStorageService;
import com.sample.movielld.service.ITheatreService;

public class TheatreService implements ITheatreService {

	IStorageService storageService;

	public TheatreService(IStorageService storageService) {
		this.storageService = storageService;
	}


	@Override
	public Theatre saveTheatre(Theatre theatre1) {
		return storageService.saveTheatre(theatre1);
	}


	@Override
	public List<Theatre> findAll() {
		return storageService.findAllTheatres();
	}


	@Override
	public Theatre findById(String theatreId) {
		return storageService.findTheatreById(theatreId);
	}
}
