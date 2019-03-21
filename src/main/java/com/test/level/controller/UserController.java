package com.test.level.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.level.entity.User;
import com.test.level.service.UserService;

@RestController

public class UserController {
	@Autowired
	private UserService userService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public List<User> userList() {
		return userService.getAllUsers();
	}

	@RequestMapping(value = "/users/{nom}", method = RequestMethod.GET)
	public User getUser(@PathVariable("nom") String nom) {
		return userService.getUser(nom);

	}

	@RequestMapping(value = "/users", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity addUser(@RequestBody User user) {
		if (userService.addUser(user)) {
			return new ResponseEntity<>(user, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("User not added", HttpStatus.BAD_REQUEST);
		}

	}
}
