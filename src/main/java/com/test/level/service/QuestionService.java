package com.test.level.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.level.entity.Question;

@Service
public class QuestionService {

	private List<Question> questions = new ArrayList<>();

	public QuestionService() {
		super();
		this.questions.addAll(Arrays.asList(new Question(01, "A1", null), new Question(22, "B2", null)));
	}

	public List<Question> getAllQuestions() {
		return questions;
	}

	public Question getQuestion(int id) {
		return questions.stream().filter(e -> e.getId() == id).findFirst().get();

	}

	public boolean addQuestion(Question question) {
		return questions.add(question);
	}

	public boolean deleteQuestion(Question question) {
		// TODO implemetn delete
		return false;
	}

	public boolean addAllQuestions(List<Question> questions) {
		// TODO implement all etudiant
		return false;
	}

	/**
	 * Method that update student
	 * 
	 * @param etudiant
	 * @return
	 */
	public boolean updateQuestion(Question question) {
		// TODO implement update
		return false;
	}

}
