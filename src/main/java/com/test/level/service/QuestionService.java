package com.test.level.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.level.model.Level;
import com.test.level.model.Question;
import com.test.level.model.Response;
import com.test.level.model.Test;
import com.test.level.populator.LevelPopulator;
import com.test.level.populator.QuestionPopulator;
import com.test.level.populator.ResponsePopulator;
import com.test.level.populator.TestPopulator;
import com.test.level.repository.QuestionRepository;
import com.test.level.repository.TestRepository;
import com.test.level.repository.entity.LevelEntity;
import com.test.level.repository.entity.QuestionEntity;
import com.test.level.repository.entity.ResponseEntity;
import com.test.level.repository.entity.TestEntity;

@Service
public class QuestionService {

	@Autowired
	private QuestionRepository questionRepository;
	
	@Autowired
	private QuestionPopulator questionPopulator;

	@Autowired
	private ResponsePopulator responsePopulator;
	
	@Autowired
	private ResponseService responseService;
	
	@Autowired
	private TestService testService;
	
	@Autowired
	private TestPopulator testPopulator;
	
	public List<Question> getAllQuestions() {
		return questionPopulator.populateList(questionRepository.findAll());
	}
	public Question findQuestion(Long id,Long testId,Long levelId,Long subjectId,Long streamId) {
		Question question =questionPopulator.toModel(questionRepository.findQuestion( testId,levelId,subjectId,streamId,id));
		question.setTest(testService.findTest(testId,levelId,subjectId,streamId));
		question.setResponse(responseService.findAllResponses(id, testId, levelId, subjectId, streamId));
		return question;
	
	}
	
	
	public List<Question> findAllQuestions(Long testId,Long levelId,Long subjectId,Long streamId) {
		List <Question> questions = questionPopulator.populateList(questionRepository.findAllQuestion(testId,levelId,subjectId,streamId ));
		for (int i=0; i<questions.size();i++) {
			Question question=questions.get(i);
			question.setTest(testService.findTest(testId,levelId,subjectId,streamId));
			questions.set(i,question);
		}
		return questions;
	
	}
	public Question getQuestion(long id) {
		return questionRepository.findById(id).map(question -> {
			return questionPopulator.toModel(question);
		}).orElse(null);
	}
	public boolean addQuestion(Question question,Long testId,Long levelId, Long subjectId, Long streamId) {
		
		Test test= testService.findTest(testId,levelId,subjectId, streamId);
		TestEntity testEntity = testPopulator.toEntity(test);
		List<Response> responses= question.getResponse();
		List<ResponseEntity> listResponses = responsePopulator.populateFrommodelList(responses);
		QuestionEntity questionEntity = questionPopulator.toEntity(question);
		questionEntity.setTest(testEntity);
		ResponseEntity response= new ResponseEntity();
		for (int i=0;i<listResponses.size();i++) {
			response=listResponses.get(i);
			response.setQuestion(questionEntity);
			listResponses.set( i, response);
		}
		
		questionEntity.setResponse(listResponses);
		
			return questionRepository.save(questionEntity) != null;
		
	}
	
//	public List<Question> getQuestionsByTestId(Long testId) {
//		return questionPopulator.populateList(questionRepository.findByTestId(testId));
//	}
//	public Question getQuestion(Long id, Long testId) {
//		List<Question> list = getQuestionsByTestId(testId);
//		Question Q = new Question();
//		for (int i = 0; i < list.size(); i++)
//			if (list.get(i).getId() == id) {
//				Q = list.get(i);
//				break;
//			}
//		return Q;
//	}
	public boolean deleteQuestion(Long id) {
		return questionRepository.findById(id).map(question -> {
			questionRepository.delete(question);
			return true;
		}).orElse(false);
	}

	public boolean updateQuestion(long id ,Question question) {

		return false;
	}
}
