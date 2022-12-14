package com.userservice.controller;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.userservice.exception.UserExistsException;
import com.userservice.exception.UserNotFoundException;
import com.userservice.model.User;
import com.userservice.service.UserService;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

@RestController
@CrossOrigin(origins="http://localhost:4200")
@RequestMapping("/users")
public class UserController {
	
	@Autowired
	private UserService user_service;

	@GetMapping("/getimage/{email}")
	public ResponseEntity<?> getDetails(@PathVariable("email") String email) {
		ResponseEntity<?> rs = null;
		try {
			User s = user_service.getDetails(email);
			rs = ResponseEntity.status(HttpStatus.OK).body(s);
		} catch (Exception e) {
			rs = ResponseEntity.status(HttpStatus.CONFLICT).build();
		}
		return rs;
	}

	@PostMapping("/login")
	public ResponseEntity<?> loginUser(@RequestBody User user) throws UserNotFoundException {
		

		User validUser = user_service.login(user.getEmail(), user.getPassword());

		if (validUser == null)
			throw new UserNotFoundException();
		String token = Jwts.builder().setId(validUser.getEmail()).setSubject(validUser.getFirstName())
				.setIssuedAt(new Date()).signWith(SignatureAlgorithm.HS256, "usersecretkey").compact();
		
		
		Map<String, String> map1 = new HashMap<String, String>();
		map1.put("token", token);
		map1.put("message", "User has Successfully logged in");
		ResponseEntity<Map<String, String>> response = new ResponseEntity<Map<String, String>>(map1, HttpStatus.OK);
		return response;

	}

	@PostMapping("/register")
	public ResponseEntity<?> registerUser(@RequestBody User u) {
		ResponseEntity<?> response = null;
		try {
			user_service.register(u);
			response = new ResponseEntity<String>(HttpStatus.OK);
		} catch (UserExistsException e) {
			response = new ResponseEntity<String>(HttpStatus.CONFLICT);
			e.printStackTrace();
		} catch (Exception e) {
			response = new ResponseEntity<String>(HttpStatus.INTERNAL_SERVER_ERROR);
			e.printStackTrace();
		}
		return response;

	}

}
