package com.test.level.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
//import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.test.level.model.Stream;
import com.test.level.model.Stream;
import com.test.level.service.StreamService;

@RestController
//allow the access from other servers
@CrossOrigin ("*") 
public class StreamController {

	@Autowired
	private StreamService streamService;
//	@Secured(value= {"ROLE_ADMIN","ROLE_PROF","ROLE_ETUDIANT"})
	@RequestMapping(value = "/streams", method = RequestMethod.GET)
	public List<Stream> streamList() {
		return streamService.getAllStreams();
	}
//	@Secured(value= {"ROLE_ADMIN","ROLE_PROF","ROLE_ETUDIANT"})
	@RequestMapping(value = "/streams/{id}", method = RequestMethod.GET)
	public Stream getStream(@PathVariable("id") Long id) {
		return streamService.getStream(id);

	}
//@Secured(value= {"ROLE_ADMIN","ROLE_PROF"})
	@RequestMapping(value = "/streams", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity addStream(@RequestBody Stream streamEntity) {
		if (streamService.addStream(streamEntity)) {
			return new ResponseEntity<>(streamEntity, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Stream not added", HttpStatus.BAD_REQUEST);
		}

	}
//@Secured(value= {"ROLE_ADMIN","ROLE_PROF"})
	@RequestMapping(value = "/streams/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity updateStreams(@RequestBody Stream stream, @PathVariable("id") Long id) {
		if (streamService.updateStream(id,stream)) {
			return new ResponseEntity<>(stream, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Stream not updated", HttpStatus.BAD_REQUEST);
		}

	}
//@Secured(value= {"ROLE_ADMIN","ROLE_PROF"})
	@RequestMapping(value = "/streams/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteStream(@PathVariable("id") Long id) {
		if (streamService.deleteStream(id)) {
			return new ResponseEntity<>("Stream deleted", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Stream not deleted", HttpStatus.BAD_REQUEST);
		}

	}
}
