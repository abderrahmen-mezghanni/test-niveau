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

	@RequestMapping(value = "/responses/questions/{questionId}/tests/{testId}/levels/{levelId}/subjects/{subjectId}/streams/{streamId}", method = RequestMethod.GET)
	public List<Response> responseList(@PathVariable("questionId") Long questionId,@PathVariable("testId") Long testId,@PathVariable("levelId") Long levelId,@PathVariable("subjectId") Long subjectId,@PathVariable("streamId") Long streamId) {
		return responseService.findAllResponses(questionId, testId, levelId, subjectId, streamId);
	}

	@RequestMapping(value = "/responses/{id}/questions/{questionId}/tests/{testId}/levels/{levelId}/subjects/{subjectId}/streams/{streamId}", method = RequestMethod.GET)
	public Response getResponse(@PathVariable("id") Long id,@PathVariable("questionId") Long questionId,@PathVariable("testId") Long testId,@PathVariable("levelId") Long levelId,@PathVariable("subjectId") Long subjectId,@PathVariable("streamId") Long streamId) {
		return responseService.findResponse(id, questionId, testId, levelId, subjectId, streamId);

	}

	@RequestMapping(value = "/responses/questions/{questionId}/tests/{testId}/levels/{levelId}/subjects/{subjectId}/streams/{streamId}", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity addResponse(@RequestBody Response response,@PathVariable("questionId") Long questionId,@PathVariable("testId") Long testId,@PathVariable("levelId") Long levelId,@PathVariable("subjectId") Long subjectId,@PathVariable("streamId") Long streamId) {
		if (responseService.addResponse(response, questionId, testId, levelId, subjectId, streamId)) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Response not added", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/responses/{id}/questions/{questionId}/tests/{testId}/levels/{levelId}/subjects/{subjectId}/streams/{streamId}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity updateResponse(@RequestBody Response response, @PathVariable("id") Long id) {
		if (responseService.updateResponse(id, response)) {
			return new ResponseEntity<>(response, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Response not updated", HttpStatus.BAD_REQUEST);
		}

	}@RequestMapping(value = "/responses/{id}/questions/{questionId}/tests/{testId}/levels/{levelId}/subjects/{subjectId}/streams/{streamId}", method = RequestMethod.DELETE)
	public ResponseEntity deleteResponse( @PathVariable("id") Long id) {
		if (responseService.deleteResponse(id)) {
			return new ResponseEntity<>("Response deleted",HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Response not deleted", HttpStatus.BAD_REQUEST);
		}

	}
}
