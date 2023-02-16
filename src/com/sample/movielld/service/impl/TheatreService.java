package com.sample.movielld.service.impl;

import com.sample.movielld.entities.Theatre;
import com.sample.movielld.service.IStorageService;
import com.sample.movielld.service.ITheatreService;

public class TheatreService implements ITheatreService {

	IStorageService storageService;

	public TheatreService(IStorageService storageService) {
		this.storageService = storageService;
	}


	@Override
	public Theatre addTheatre(Theatre theatre1) {
		return storageService.addTheatre(theatre1);
	}
}
