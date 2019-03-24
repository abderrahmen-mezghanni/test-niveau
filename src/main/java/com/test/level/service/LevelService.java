package com.test.level.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.level.model.Level;

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

	public boolean deleteLevel(int id) {
		levels.removeIf(a -> a.getId() == id);
		return true;
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
	public boolean updateLevel(int id ,Level level) {
		for (int i = 0; i < levels.size(); i++) {
		Level a = levels.get(i);
			if (a.getId() == level.getId()) {
				levels.set(i, level);
				return true;
			}

		}
		return false;
	}

}
