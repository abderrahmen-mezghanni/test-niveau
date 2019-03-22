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

import com.test.level.entity.Administrator;
import com.test.level.service.AdministratorService;

@RestController
public class AdministratorControlleur {

	@Autowired
	private AdministratorService administratorService;

	@RequestMapping(value = "/administrators", method = RequestMethod.GET)
	public List<Administrator> administratorList() {
		return administratorService.getAllAdministrators();
	}

	@RequestMapping(value = "/administrators/{id}", method = RequestMethod.GET)
	public Administrator getAdministrator(@PathVariable("id") int id) {
		return administratorService.getAdministrator(id);

	}

	@RequestMapping(value = "/administrators", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity addAdministrator(@RequestBody Administrator administrator) {
		if (administratorService.addAdministrator(administrator)) {
			return new ResponseEntity<>(administrator, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Administrator not added", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/administrators/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity updateAdministrator(@RequestBody Administrator administrator, @PathVariable("id") int id) {
		if (administratorService.updateAdministrator(id, administrator)) {
			return new ResponseEntity<>(administrator, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Administrator not updated", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/administrators/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteAdministrator( @PathVariable("id") int id) {
		if (administratorService.deleteAdministrator(id)) {
			return new ResponseEntity<>("Administrator deleted",HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Administrator not deleted", HttpStatus.BAD_REQUEST);
		}

	}

}
