package com.sample.movielld.service.impl;

import java.util.List;

import com.sample.movielld.entities.Show;
import com.sample.movielld.service.ISearchService;
import com.sample.movielld.service.IStorageService;

public class SearchService implements ISearchService {
	
	IStorageService storageService;

	public SearchService(IStorageService storageService) {
		this.storageService = storageService;
	}

	@Override
	public List<Show> findShows(String movieSearchTerm) {
		return storageService.findShows(movieSearchTerm);
	}

}
