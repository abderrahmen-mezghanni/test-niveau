package com.test.level.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.level.model.Administrator;
import com.test.level.model.User;
import com.test.level.service.AdministratorService;

@RestController

// allow the access from other servers
@CrossOrigin ("*") 
public class AdministratorControlleur {

	@Autowired
	private AdministratorService administratorService;

	@RequestMapping(value = "/administrators", method = RequestMethod.GET)
	public List<User> administratorList() {
		return administratorService.getAllAdministrtors();
	}

	@RequestMapping(value = "/administrators/{cin}", method = RequestMethod.GET)
	public User getAdministrator(@PathVariable("cin") Long cin) {
		return administratorService.findAdministrator(cin);

	}

	@RequestMapping(value = "/administrators", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity addAdministrator(@RequestBody Administrator administrator) {
		if (administratorService.addAdministrator(administrator)) {
			return new ResponseEntity<>(administrator, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Administrator not added", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/administrators/{cin}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity updateAdministrator(@RequestBody Administrator administrator, @PathVariable("cin") Long cin) {
		if (administratorService.updateAdministrator(cin, administrator)) {
			return new ResponseEntity<>(administrator, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Administrator not updated", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/administrators/{cin}", method = RequestMethod.DELETE)
	public ResponseEntity deleteAdministrator( @PathVariable("cin") Long cin) {
		if (administratorService.deleteAdministrator(cin)) {
			return new ResponseEntity<>("Administrator deleted",HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Administrator not deleted", HttpStatus.BAD_REQUEST);
		}

	}

}
