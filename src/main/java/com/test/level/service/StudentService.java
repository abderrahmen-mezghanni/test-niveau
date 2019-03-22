package com.test.level.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.level.entity.Student;

@Service
public class StudentService {

	private List<Student> students = new ArrayList<>();

	public StudentService() {
		super();
		this.students.addAll(Arrays.asList(new Student(055, 55, "mahamed", "salah"),
				new Student(458, 55, "salah", "mohamed"), new Student(420, 47, "salah", "salah55")));
	}

	public List<Student> getAllStudents() {
		return students;
	}

	public Student getStudent(String nom) {
		return students.stream().filter(e -> e.getNom().equals(nom)).findFirst().get();

	}

	public boolean addStudent(Student student ) {
			return students.add(student);
		}

	public boolean deleteStudent(Student student) {
		// TODO implemetn delete
		return false;
	}

	public boolean addAllStudents(List<Student> students) {
		// TODO implement all etudiant
		return false;
	}

	/**
	 * Method that update student
	 * 
	 * @param etudiant
	 * @return
	 */
	public boolean updateStudent(Student student) {
		// TODO implement update
		return false;
	}

}
