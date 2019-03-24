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

import com.test.level.model.Level;
import com.test.level.service.LevelService;

@RestController
public class LevelController {

	@Autowired
	private LevelService levelService;

	@RequestMapping(value = "/levels", method = RequestMethod.GET)
	public List<Level> levelList() {
		return levelService.getAllLevels();
	}

	@RequestMapping(value = "/levels/{nom}", method = RequestMethod.GET)
	public Level getLevel(@PathVariable("nom") String nom) {
		return levelService.getLevel(nom);

	}

	@RequestMapping(value = "/levels", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity addLevel(@RequestBody Level level) {
		if (levelService.addLevel(level)) {
			return new ResponseEntity<>(level, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Level not added", HttpStatus.BAD_REQUEST);
		}

	}

	@RequestMapping(value = "/level/{id}", method = RequestMethod.PUT, consumes = "application/json")
	public ResponseEntity updateLevel(@RequestBody Level level, @PathVariable("id") int id) {
		if (levelService.updateLevel(id, level)) {
			return new ResponseEntity<>(level, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Level not updated", HttpStatus.BAD_REQUEST);
		}

	}@RequestMapping(value = "/level/{id}", method = RequestMethod.DELETE)
	public ResponseEntity deleteLevel( @PathVariable("id") int id) {
		if (levelService.deleteLevel(id)) {
			return new ResponseEntity<>( "Level deleted",HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Level not deleted", HttpStatus.BAD_REQUEST);
		}

	}
}