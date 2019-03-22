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
import com.test.level.entity.Subject;
import com.test.level.service.SubjectService;

@RestController

public class SubjectController {

	@Autowired
	private SubjectService subjectService;

	@RequestMapping(value = "/subjects", method = RequestMethod.GET)
	public List<Subject> SubjectList() {
		return subjectService.getAllSubjects();
	}

	@RequestMapping(value = "/subjects/{nom}", method = RequestMethod.GET)
	public Subject getSubject(@PathVariable("nom") String nom) {
		return subjectService.getSubject(nom);

	}

	@RequestMapping(value = "/subjects", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity addLevel(@RequestBody Subject subject) {
		if (subjectService.addSubject(subject)) {
			return new ResponseEntity<>(subject, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Subject not added", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/subjects/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity updateSubject(@RequestBody Subject subject, @PathVariable("id") int id) {
		if (subjectService.updateSubject(id, subject)) {
			return new ResponseEntity<>(subject, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Subject not updated", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/subjects/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteSubject(@PathVariable("id") int id) {
		if (subjectService.deleteSubject(id)) {
			return new ResponseEntity<>("Subject deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Subject not deleted", HttpStatus.BAD_REQUEST);
		}

	}
}
