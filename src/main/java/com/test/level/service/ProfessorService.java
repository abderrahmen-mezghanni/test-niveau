package com.test.level.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.level.model.Professor;

@Service
public class ProfessorService {

	private List<Professor> professors = new ArrayList<>();

	public ProfessorService() {
		super();
		this.professors.addAll(Arrays.asList(new Professor(055, 55, "mahamed", "salah"),
				new Professor(458, 55, "salah", "mohamed"), new Professor(420, 47, "salah", "salah55")));
	}

	public List<Professor> getAllProfessors() {
		return professors;
	}

	public Professor getProfessor(String nom) {
		return professors.stream().filter(e -> e.getNom().equals(nom)).findFirst().get();

	}

	public boolean addProfessor(Professor professor) {
		return professors.add(professor);
	}

	public boolean deleteProfessor(int id) {
		professors.removeIf(a -> a.getId() == id);
		return true;
	}

	public boolean addAllProfessors(List<Professor> professors) {
		// TODO implement all etudiant
		return false;
	}

	/**
	 * Method that update student
	 * 
	 * @param etudiant
	 * @return
	 */
	public boolean updateProfessor(int id, Professor professor) {
		for (int i = 0; i < professors.size(); i++) {
			Professor a = professors.get(i);
			if (a.getId() == professor.getId()) {
				professors.set(i, professor);
				return true;
			}

		}
		return false;
	}

}
