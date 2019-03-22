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
import com.test.level.entity.Student;
import com.test.level.service.StudentService;

@RestController
public class StudentController {
	@Autowired
	private StudentService studentService;

	@RequestMapping(value = "/students", method = RequestMethod.GET)
	public List<Student> studentList() {
		return studentService.getAllStudents();
	}

	@RequestMapping(value = "/students/{nom}", method = RequestMethod.GET)
	public Student getStudent(@PathVariable("nom") String nom) {
		return studentService.getStudent(nom);

	}

	@RequestMapping(value = "/students", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity addStudent(@RequestBody Student student) {
		if (studentService.addStudent(student)) {
			return new ResponseEntity<>(student, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Student not added", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity updateStudent(@RequestBody Student student, @PathVariable("id") int id) {
		if (studentService.updateStudent(id, student)) {
			return new ResponseEntity<>(student, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Student not updated", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/students/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteStudent(@PathVariable("id") int id) {
		if (studentService.deleteStudent(id)) {
			return new ResponseEntity<>("Student deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Student not deleted", HttpStatus.BAD_REQUEST);
		}

	}
}
