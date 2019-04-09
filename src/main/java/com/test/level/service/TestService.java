package com.test.level.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.level.model.Level;
import com.test.level.model.Subject;
import com.test.level.model.Test;
import com.test.level.populator.LevelPopulator;
import com.test.level.populator.SubjectPopulator;
import com.test.level.populator.TestPopulator;
import com.test.level.repository.LevelRepository;
import com.test.level.repository.TestRepository;
import com.test.level.repository.entity.LevelEntity;
import com.test.level.repository.entity.SubjectEntity;
import com.test.level.repository.entity.TestEntity;

@Service
public class TestService {

	@Autowired
	private TestRepository testRepository;

	@Autowired
	private TestPopulator testPopulator;

	@Autowired
	private LevelService levelService;

	@Autowired
	private LevelPopulator levelPopulator;

	public List<Test> getAllTests() {
		return testPopulator.populateList(testRepository.findAll());
	}

	public Test findTest(Long id, Long levelId, Long subjectId, Long streamId) {
		Test test = testPopulator.toModel(testRepository.findTest(levelId,subjectId,streamId,id));
		test.setLevel(levelService.findLevel(levelId,subjectId,streamId));
		return test;

	}

	public List<Test> findAllTests(Long levelId, Long subjectId, Long streamId) {
		List<Test> tests = testPopulator.populateList(testRepository.findAllTest(levelId,subjectId,streamId));
//		level.setSubject(subjectService.getSubject(subjectId,streamId));
		for (int i = 0; i < tests.size(); i++) {
			Test test = tests.get(i);
			test.setLevel(levelService.findLevel(levelId,subjectId,streamId));
			tests.set(i, test);
		}
		return tests;

	}

	public Test getTest(long id) {
		return testRepository.findById(id).map(test -> {
			return testPopulator.toModel(test);
		}).orElse(null);
	}

	public boolean addTest(Test test, Long levelId, Long subjectId, Long streamId) {

		Level level = levelService.findLevel(levelId,subjectId,streamId);
		LevelEntity LevelEntity = levelPopulator.toEntity(level);
		TestEntity testEntity = testPopulator.toEntity(test);
		testEntity.setLevel(LevelEntity);

		return testRepository.save(testEntity) != null;

	}

//	public List<Test> getTestsByLevelId(Long levelId) {
//		return testPopulator.populateList(testRepository.findByLevelId(levelId));
//	}
//
//	public Test getTest(Long id, Long levelId) {
//		List<Test> list = getTestsByLevelId(levelId);
//		Test T = new Test();
//		for (int i = 0; i < list.size(); i++)
//			if (list.get(i).getId() == id) {
//				T = list.get(i);
//				break;
//			}
//		return T;
//	}

	public boolean deleteTest(Long id) {
		return testRepository.findById(id).map(test -> {
			testRepository.delete(test);
			return true;
		}).orElse(false);
	}

	public boolean updateTest(long id, Test test) {

		return false;
	}
}
