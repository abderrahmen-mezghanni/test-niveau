package com.test.level.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.level.entity.Level;

@Service
public class LevelService {

	private List<Level> levels = new ArrayList<>();

	public LevelService() {
		super();
		this.levels.addAll(Arrays.asList(new Level(01, "A1"), new Level(22, "B2")));
	}

	public List<Level> getAllLevels() {
		return levels;
	}

	public Level getLevel(String nom) {
		return levels.stream().filter(e -> e.getNom().equals(nom)).findFirst().get();

	}

	public boolean addLevel(Level level) {
		return levels.add(level);
	}

	public boolean deleteLevel(Level level) {
		// TODO implemetn delete
		return false;
	}

	public boolean addAllLevels(List<Level> levels) {
		// TODO implement all etudiant
		return false;
	}

	/**
	 * Method that update student
	 * 
	 * @param etudiant
	 * @return
	 */
	public boolean updateSubject(Level level) {
		// TODO implement update
		return false;
	}

}
