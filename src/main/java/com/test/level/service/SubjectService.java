package com.test.level.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.level.entity.Subject;

@Service
public class SubjectService {

	private List<Subject> subjects = new ArrayList<>();

	public SubjectService() {
		super();
		this.subjects.addAll(Arrays.asList(new Subject(055, "proba", null), new Subject(458, "recherche", null)));
	}

	public List<Subject> getAllSubjects() {
		return subjects;
	}

	public Subject getSubject(String nom) {
		return subjects.stream().filter(e -> e.getNom().equals(nom)).findFirst().get();

	}

	public boolean addSubject(Subject subject) {
		return subjects.add(subject);
	}

	public boolean deleteSubject(int id) {
		subjects.removeIf(a ->a.getId()==id);
		return true;
	}

	public boolean addAllSubjects(List<Subject> students) {
		// TODO implement all etudiant
		return false;
	}

	/**
	 * Method that update student
	 * 
	 * @param etudiant
	 * @return
	 */
	public boolean updateSubject(int id, Subject subject) {
		for (int i = 0; i < subjects.size(); i++) {
			Subject a = subjects.get(i);
			if (a.getId() == subject.getId()) {
				subjects.set(i, subject);
				return true;
			}

		}
		return false;
	}

}
