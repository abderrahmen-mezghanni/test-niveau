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


import com.test.level.model.Subject;
import com.test.level.service.SubjectService;

@RestController
//allow the access from other servers
@CrossOrigin ("*") 
public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@RequestMapping(value = "/subjects/streams/{streamId}", method = RequestMethod.GET)
	public List<Subject> SubjectList(@PathVariable("streamId") Long streamId) {
		return subjectService.getSubjectsByStreamId(streamId);
	}

	@RequestMapping(value = "/subjects/{id}/streams/{streamId}", method = RequestMethod.GET)
	public Subject getSubject(@PathVariable("id") Long id, @PathVariable("streamId") Long streamId) {
		return subjectService.getSubject(id,streamId);

	}

	@RequestMapping(value = "/subjects/streams/{streamId}", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity addSubject(@RequestBody Subject subject, @PathVariable("streamId") Long streamId) {
		if (subjectService.addSubject(subject,streamId)) {
			return new ResponseEntity<>(subject, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Subject not added", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/subjects/{id}/streams/{streamId}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity updateSubject(@RequestBody Subject subject, @PathVariable("id") Long id, @PathVariable("streamId") Long streamId) {
		if (subjectService.updateSubject(id,subject,streamId)) {
			return new ResponseEntity<>(subject, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Subject not updated", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/subjects/{id}/streams/{streamId}", method = RequestMethod.DELETE)
	public ResponseEntity deleteSubject(@PathVariable("id") Long id) {
		if (subjectService.deleteSubject(id)) {
			return new ResponseEntity<>("Subject deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Subject not deleted", HttpStatus.BAD_REQUEST);
		}

	}
}
