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

import com.test.level.entity.Professor;
import com.test.level.service.ProfessorService;

@RestController
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	@RequestMapping(value = "/professors", method = RequestMethod.GET)
	public List<Professor> professorList() {
		return professorService.getAllProfessors();
	}

	@RequestMapping(value = "/professors/{nom}", method = RequestMethod.GET)
	public Professor getProfessorr(@PathVariable("nom") String nom) {
		return professorService.getProfessor(nom);

	}

	@RequestMapping(value = "/professors", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity addUser(@RequestBody Professor professor) {
		if (professorService.addProfessor(professor)) {
			return new ResponseEntity<>(professor, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Professor not added", HttpStatus.BAD_REQUEST);
		}

	}
}
