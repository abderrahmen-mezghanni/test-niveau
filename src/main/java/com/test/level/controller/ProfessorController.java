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

import com.test.level.model.Professor;
import com.test.level.model.User;
import com.test.level.service.ProfessorService;

@RestController
//allow the access from other servers
@CrossOrigin ("*") 
public class ProfessorController {

	@Autowired
	private ProfessorService professorService;

	@RequestMapping(value = "/professors", method = RequestMethod.GET)
	public List<User> professorList() {
		return professorService.getAllProfessors();
	}

	@RequestMapping(value = "/professors/{cin}", method = RequestMethod.GET)
	public User getAdministrator(@PathVariable("cin") Long cin) {
		return professorService.findProfessor(cin);

	}

	@RequestMapping(value = "/professors", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity addProfessor(@RequestBody Professor professor) {
		if (professorService.addProfessor(professor)) {
			return new ResponseEntity<>(professor, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Professor not added", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/professors/{cin}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity updateProfessor(@RequestBody Professor professor, @PathVariable("cin") Long cin) {
		if (professorService.updateProfessor(cin, professor)) {
			return new ResponseEntity<>(professor, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Professor not updated", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/professors/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteProfessor(@PathVariable("cin") Long cin) {
		if (professorService.deleteProfessor(cin)) {
			return new ResponseEntity<>("Professor deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Professor not deleted", HttpStatus.BAD_REQUEST);
		}

	}
}
