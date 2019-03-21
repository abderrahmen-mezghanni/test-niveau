package com.test.level.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.level.entity.Test;

@Service
public class TestService {

	private List<Test> tests = new ArrayList<>();

	public TestService() {
		super();
		this.tests.addAll(Arrays.asList(new Test(01, null), new Test(02, null)));
	}

	public List<Test> getAllTests() {
		return tests;
	}

	public Test getSteam(int id) {
		return tests.stream().filter(e -> e.getId() == id).findFirst().get();

	}

	public boolean addTest(Test test) {
		return tests.add(test);
	}

	public boolean deleteTest(Test test) {
		// TODO implemetn delete
		return false;
	}

	public boolean addAllTests(List<Test> tests) {
		// TODO implement all etudiant
		return false;
	}

	/**
	 * Method that update student
	 * 
	 * @param etudiant
	 * @return
	 */
	public boolean updateTest(Test test) {
		// TODO implement update
		return false;
	}

}
