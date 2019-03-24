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

import com.test.level.model.Response;
import com.test.level.service.ResponseService;

@RestController
public class ResponseController {

	@Autowired
	private ResponseService responseService;

	@RequestMapping(value = "/responses", method = RequestMethod.GET)
	public List<Response> responseList() {
		return responseService.getAllResponses();
	}

	@RequestMapping(value = "/responses/{id}", method = RequestMethod.GET)
	public Response getResponse(@PathVariable("id") int id) {
		return responseService.getResponse(id);

	}

	@RequestMapping(value = "/responses", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity addResponse(@RequestBody Response response) {
		if (responseService.addResponse(response)) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Response not added", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/responses/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity updateResponse(@RequestBody Response response, @PathVariable("id") int id) {
		if (responseService.updateResponse(id, response)) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Administrator not updated", HttpStatus.BAD_REQUEST);
		}

	}@RequestMapping(value = "/responses/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteResponse( @PathVariable("id") int id) {
		if (responseService.deleteResponse(id)) {
			return new ResponseEntity<>("Administrator deleted",HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Administrator not deleted", HttpStatus.BAD_REQUEST);
		}

	}
}
