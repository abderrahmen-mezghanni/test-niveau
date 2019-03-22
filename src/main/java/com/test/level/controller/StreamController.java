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

import com.test.level.entity.Stream;
import com.test.level.service.StreamService;

@RestController
public class StreamController {

	@Autowired
	private StreamService streamService;

	@RequestMapping(value = "/streams", method = RequestMethod.GET)
	public List<Stream> streamList() {
		return streamService.getAllStreams();
	}

	@RequestMapping(value = "/streams/{id}", method = RequestMethod.GET)
	public Stream getStream(@PathVariable("id") int id) {
		return streamService.getStream(id);

	}

	@RequestMapping(value = "/streams", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity addStream(@RequestBody Stream stream) {
		if (streamService.addStream(stream)) {
			return new ResponseEntity<>(stream, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Stream not added", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/streams/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity updateStreams(@RequestBody Stream stream, @PathVariable("id") int id) {
		if (streamService.updateStream(id, stream)) {
			return new ResponseEntity<>(stream, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Stream not updated", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/streams/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteStreams(@PathVariable("id") int id) {
		if (streamService.deleteStream(id)) {
			return new ResponseEntity<>("Stream deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Stream not deleted", HttpStatus.BAD_REQUEST);
		}

	}
}
