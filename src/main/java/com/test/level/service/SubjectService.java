package com.test.level.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.level.model.Subject;
import com.test.level.populator.SubjectPopulator;
import com.test.level.repository.SubjectRepository;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private SubjectPopulator subjectPopulator;

	public List<Subject> getAllSubjects() {
		return subjectPopulator.populateList(subjectRepository.findAll());
	}

	public Subject getSubject(Long id) {
		return subjectRepository.findById(id).map(stream -> {
			return subjectPopulator.toModel(stream);
		}).orElse(null);
	}

	public boolean addSubject(Subject subject) {
		return subjectRepository.save(subjectPopulator.toEntity(subject)) != null;
	}

	public boolean deleteSubject(Long id) {
		return subjectRepository.findById(id).map(stream -> {
			subjectRepository.delete(stream);
			return true;
		}).orElse(false);
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
//		for (int i = 0; i < subjects.size(); i++) {
//			Subject a = subjects.get(i);
//			if (a.getId() == subject.getId()) {
//				subjects.set(i, subject);
//				return true;
//			}
//
//		}
		return false;
	}

}