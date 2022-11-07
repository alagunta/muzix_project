package com.userservice.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.userservice.model.User;

public interface UserRepository extends JpaRepository<User,String>{
	
	public User findByEmail(String email);

	public List<User> findByEmailAndPassword(String email, String password);

}
