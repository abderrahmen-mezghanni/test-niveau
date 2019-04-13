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

import com.test.level.model.Level;
import com.test.level.repository.LevelRepository;
import com.test.level.service.LevelService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="Level", description="CRUD operation on level")
@RestController
//allow the access from other servers
@CrossOrigin ("*") 
public class LevelController {

	@Autowired
	private LevelService levelService;
	
	@ApiOperation(value = "View a list of available levels", response = List.class)
	@RequestMapping(value = "/levels/subjects/{subjectId}/streams/{streamId}", method = RequestMethod.GET)
	public List<Level> levelList(@PathVariable("streamId") Long streamId,@PathVariable("subjectId") Long subjectId) {
		return levelService.findAllLevels(subjectId,streamId);
	}
	@ApiOperation(value = "Get level by id", response = Level.class)
	@RequestMapping(value = "/levels/{id}/subjects/{subjectId}/streams/{streamId}", method = RequestMethod.GET)
	public Level getLevel(@PathVariable("id") Long id,@PathVariable("subjectId") Long subjectId,@PathVariable("streamId") Long streamId) {
		return levelService.findLevel( id, subjectId,streamId);

	}

	@RequestMapping(value = "/levels/subjects/{subjectId}/streams/{streamId}", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity addLevel(@RequestBody Level level,@PathVariable("streamId")Long streamId,@PathVariable("subjectId") Long subjectId) {
		if (levelService.addLevel(level,subjectId,streamId)) {
			return new ResponseEntity<>(level, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Level not added", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/level/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity updateLevel(@RequestBody Level level, @PathVariable("id") Long id) {
		if (levelService.updateLevel(id, level)) {
			return new ResponseEntity<>(level, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Level not updated", HttpStatus.BAD_REQUEST);		}

	}@RequestMapping(value = "/level/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteLevel( @PathVariable("id") Long id) {
		if (levelService.deleteLevel(id)) {
			return new ResponseEntity<>( "Level deleted",HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Level not deleted", HttpStatus.BAD_REQUEST);
		}

	}
}
