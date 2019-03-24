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

import com.test.level.model.Question;
import com.test.level.service.QuestionService;

@RestController
public class QuestionController {

	@Autowired
	private QuestionService questionService;

	@RequestMapping(value = "/questions", method = RequestMethod.GET)
	public List<Question> questionList() {
		return questionService.getAllQuestions();
	}

	@RequestMapping(value = "/questions/{id}", method = RequestMethod.GET)
	public Question getQuestion(@PathVariable("id") int id) {
		return questionService.getQuestion(id);

	}

	@RequestMapping(value = "/questions", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity addQuestion(@RequestBody Question question) {
		if (questionService.addQuestion(question)) {
			return new ResponseEntity<>(question, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Question not added", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/questions/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity updateUser(@RequestBody Question question, @PathVariable("id") int id) {
		if (questionService.updateQuestion(id, question)) {
			return new ResponseEntity<>(question, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("question not updated", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/questions/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteUser(@PathVariable("id") int id) {
		if (questionService.deleteQuestion(id)) {
			return new ResponseEntity<>("question deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("question not deleted", HttpStatus.BAD_REQUEST);
		}

	}
}