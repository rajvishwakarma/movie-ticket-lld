package com.sample.movielld.service;

import java.util.List;

import com.sample.movielld.entities.Show;

public interface ISearchService {


	List<Show> findShows(String movieSearchTerm);

}
