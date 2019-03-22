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

	public class AdministratorController {
		@Autowired
		private AdministratorService administratorService;

		@RequestMapping(value = "/administrators", method = RequestMethod.GET)
		public List<Administrator> administratorList() {
			return administratorService.getAllAdministrators();
		}

		@RequestMapping(value = "/administrators/{nom}", method = RequestMethod.GET)
		public Administrator getAdministrator(@PathVariable("nom") String nom) {
			return administratorService.getAdministrator(nom);

		}

		@RequestMapping(value = "/administrators", method = RequestMethod.POST, consumes = "application/json")
		public ResponseEntity addUser(@RequestBody Administrator administrator) {
			if (administratorService.addAdministrator(administrator)) {
				return new ResponseEntity<>(administrator, HttpStatus.OK);
			} else {
				return new ResponseEntity<>("User not added", HttpStatus.BAD_REQUEST);
			}

		}
	}
}
