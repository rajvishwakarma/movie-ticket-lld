package com.sample.movielld.service;

import com.sample.movielld.entities.Show;
import com.sample.movielld.request.ShowRequest;

public interface IShowService {

	Show saveShow(Show show1);

	Show createShow(ShowRequest request);

	Show findById(String id);

}
