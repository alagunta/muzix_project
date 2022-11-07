package com.userservice.service;

import com.userservice.exception.UserExistsException;
import com.userservice.model.User;

public interface UserService {
	
	public User getDetails(String email);

	public User login(String email, String password);

	public void register(User u) throws UserExistsException;


}
