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
		this.subjects.addAll(Arrays.asList(new Subject(055, "proba", null), new Subject(458, "recherche",null)));
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

	public boolean deleteSubjects(Subject student) {
		// TODO implemetn delete
		return false;
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
	public boolean updateSubject(Subject student) {
		// TODO implement update
		return false;
	}

}
