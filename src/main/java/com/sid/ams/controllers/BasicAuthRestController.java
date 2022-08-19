package com.sid.ams.controllers;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sid.ams.entities.AuthenticationBean;
import com.sid.ams.entities.User;

@CrossOrigin(origins = "*")//http://localhost:4200
@RestController
public class BasicAuthRestController {
	@GetMapping(path = "/basicauth")
	public User basicauth() {
		return new User("med@gmail.com","1234");
	}

}
