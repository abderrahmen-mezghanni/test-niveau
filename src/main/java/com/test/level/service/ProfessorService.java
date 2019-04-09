package com.test.level.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.level.model.Administrator;
import com.test.level.model.Professor;
import com.test.level.model.User;
import com.test.level.populator.UserPopulator;
import com.test.level.repository.UserRepository;
import com.test.level.repository.entity.AdministratorEntity;
import com.test.level.repository.entity.ProfessorEntity;

@Service
public class ProfessorService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserPopulator userPopulator;

	public List<User> getAllProfessors() {
		return userPopulator.populateList(userRepository.findAllProfessors());
	}

	public Professor findProfessor(Long professorCin) {
		Professor professor = (Professor) userPopulator
				.toModel(userRepository.findProfessor(professorCin));
		return professor;

	}

	public boolean addProfessor(Professor professor) {
		ProfessorEntity professorEntity = (ProfessorEntity) userPopulator.toEntity(professor);
		return userRepository.save(professorEntity) != null;
	}

	public boolean deleteProfessor(Long professorCin) {
		return userRepository.findById(professorCin).map(professor -> {
			userRepository.delete(professor);
			return true;
		}).orElse(false);
	}
	
	public boolean updateProfessor(long professorCin ,Professor professor) {

		return false;
	}

}
