package com.sample.movielld.service;

import java.util.List;

import com.sample.movielld.entities.Theatre;

public interface ITheatreService {

	Theatre saveTheatre(Theatre theatre1);

	List<Theatre> findAll();

	Theatre findById(String theatreId);

}
