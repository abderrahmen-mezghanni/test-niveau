package com.test.level.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.level.model.Administrator;
import com.test.level.model.Student;
import com.test.level.model.User;
import com.test.level.populator.UserPopulator;
import com.test.level.repository.UserRepository;
import com.test.level.repository.entity.AdministratorEntity;
import com.test.level.repository.entity.StudentEntity;

@Service
public class StudentService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserPopulator userPopulator;

	public List<User> getAllStudents() {
		return userPopulator.populateList(userRepository.findAllStudents());
	}

	public Student findStudent(Long studentCin) {
		Student student = (Student) userPopulator
				.toModel(userRepository.findStudent(studentCin));
		return student;

	}

	public boolean addStudent(Student student) {
		StudentEntity studentEntity = (StudentEntity) userPopulator.toEntity(student);
		return userRepository.save(studentEntity) != null;
	}

	public boolean deleteStudent(Long studentCin) {
		return userRepository.findById(studentCin).map(student -> {
			userRepository.delete(student);
			return true;
		}).orElse(false);
	}
	
	public boolean updateStudent(long cin ,Student student) {

		return false;
	}

}
