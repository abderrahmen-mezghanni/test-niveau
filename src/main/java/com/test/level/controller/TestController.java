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

	@RequestMapping(value = "/tests/levels/{levelId}/subjects/{subjectId}/streams/{streamId}", method = RequestMethod.GET)
	public List<Test> testList(@PathVariable("levelId") Long levelId, @PathVariable("subjectId") Long subjectId,
			@PathVariable("streamId") Long streamId) {
		return testService.findAllTests(levelId, subjectId, streamId);
	}

	@RequestMapping(value = "/tests/{id}/levels/{levelId}/subjects/{subjectId}/streams/{streamId}", method = RequestMethod.GET)
	public Test getTest(@PathVariable("levelId") Long levelId, @PathVariable("subjectId") Long subjectId,
			@PathVariable("streamId") Long streamId, @PathVariable("id") Long id) {
		return testService.findTest(id, streamId, streamId, streamId);

	}

	@RequestMapping(value = "/tests/levels/{levelId}/subjects/{subjectId}/streams/{streamId}", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity addLevel(@RequestBody Test test, @PathVariable("levelId") Long levelId,
			@PathVariable("subjectId") Long subjectId, @PathVariable("streamId") Long streamId) {
		if (testService.addTest(test, levelId, subjectId, streamId)) {
			return new ResponseEntity<>(test, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Subject not added", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/tests/{id}/levels/{levelId}/subjects/{subjectId}/streams/{streamId}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity updateTest(@RequestBody Test test, @PathVariable("id") Long id,
			@PathVariable("levelId") Long levelId, @PathVariable("subjectId") Long subjectId,
			@PathVariable("streamId") Long streamId) {
		if (testService.updateTest(id, test)) {
			return new ResponseEntity<>(test, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Test not updated", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/tests/{id}/levels/{levelId}/subjects/{subjectId}/streams/{streamId}", method = RequestMethod.DELETE)
	public ResponseEntity deleteTest(@PathVariable("id") Long id) {
		if (testService.deleteTest(id)) {
			return new ResponseEntity<>("Test deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Test not deleted", HttpStatus.BAD_REQUEST);
		}

	}
}
