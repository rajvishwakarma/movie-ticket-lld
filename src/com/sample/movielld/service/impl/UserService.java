package com.sample.movielld.service.impl;

import com.sample.movielld.entities.User;
import com.sample.movielld.service.IStorageService;
import com.sample.movielld.service.IUserService;

public class UserService implements IUserService {
	
	IStorageService storageService;

	public UserService(IStorageService storageService) {
		this.storageService = storageService;
	}

	@Override
	public User addUser(User u1) {
		return storageService.saveUser(u1);
	}

	@Override
	public User getUser(long id) {
		return storageService.getUser(id);
	}
	
}
