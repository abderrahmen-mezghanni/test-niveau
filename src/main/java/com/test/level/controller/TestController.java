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

import com.test.level.model.Test;
import com.test.level.service.TestService;

@RestController

public class TestController {

	@Autowired
	private TestService testService;

	@RequestMapping(value = "/tests", method = RequestMethod.GET)
	public List<Test> testList() {
		return testService.getAllTests();
	}

	@RequestMapping(value = "/tests/{id}", method = RequestMethod.GET)
	public Test getSubject(@PathVariable("id") int id) {
		return testService.getTest(id);

	}

	@RequestMapping(value = "/tests", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity addLevel(@RequestBody Test test) {
		if (testService.addTest(test)) {
			return new ResponseEntity<>(test, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Subject not added", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/tests/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity updateTest(@RequestBody Test test, @PathVariable("id") int id) {
		if (testService.updateTest(id, test)) {
			return new ResponseEntity<>(test, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Test not updated", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/tests/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteTest(@PathVariable("id") int id) {
		if (testService.deleteTest(id)) {
			return new ResponseEntity<>("Test deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Test not deleted", HttpStatus.BAD_REQUEST);
		}

	}
}
