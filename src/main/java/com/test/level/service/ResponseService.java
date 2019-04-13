package com.test.level.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.level.model.Question;
import com.test.level.model.Response;
import com.test.level.model.Test;
import com.test.level.populator.QuestionPopulator;
import com.test.level.populator.ResponsePopulator;
import com.test.level.populator.TestPopulator;
import com.test.level.repository.QuestionRepository;
import com.test.level.repository.ResponseRepository;
import com.test.level.repository.entity.QuestionEntity;
import com.test.level.repository.entity.ResponseEntity;
import com.test.level.repository.entity.TestEntity;
@Service
public class ResponseService {
	@Autowired
	private ResponseRepository responseRepository;
	
	@Autowired
	private ResponsePopulator responsePopulator;
	
//	@Autowired
//	private QuestionService questionService;
//	
//	@Autowired
//	private QuestionPopulator questionPopulator;
	
	public List<Response> getAllResponses() {
		return responsePopulator.populateList(responseRepository.findAll());
	}
	public Response findResponse(Long questionId,Long testId,Long levelId,Long subjectId,Long streamId,Long id) {
		Response response =responsePopulator.toModel(responseRepository.findResponse(questionId,testId,levelId,subjectId,streamId,id));
		return response;
	
	}
	
	
	public List<Response> findAllResponses(Long questionId,Long testId,Long levelId,Long subjectId,Long streamId) {
		List <Response> responses = responsePopulator.populateList(responseRepository.findAllResponse(questionId,testId,levelId,subjectId,streamId));
		for (int i=0; i<responses.size();i++) {
			Response response=responses.get(i);
			responses.set(i,response);
		}
		return responses;
	
	}
	public Response getResponse(long id) {
		return responseRepository.findById(id).map(response -> {
			return responsePopulator.toModel(response);
		}).orElse(null);
	}
	public boolean addResponse(Response response,Long questionId,Long testId,Long levelId, Long subjectId, Long streamId) {
		
		ResponseEntity responseEntity = responsePopulator.toEntity(response);
		
			return responseRepository.save(responseEntity) != null;
		
	}
	
//	public List<Response> getResponseByQuestionId(Long questionId) {
//		return responsePopulator.populateList(responseRepository.findByQuestionId(questionId));
//	}
//	public Response getResponse(Long id, Long questionId) {
//		List<Response> list = getResponseByQuestionId(questionId);
//		Response R = new Response();
//		for (int i = 0; i < list.size(); i++)
//			if (list.get(i).getId() == id) {
//				R = list.get(i);
//				break;
//			}
//		return R;
//	}
	public boolean deleteResponse(Long id) {
		return responseRepository.findById(id).map(response -> {
			responseRepository.delete(response);
			return true;
		}).orElse(false);
	}

	public boolean updateResponse(long id ,Response response) {

		return false;
	}
	}


