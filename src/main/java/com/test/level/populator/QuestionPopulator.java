package com.test.level.populator;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.level.model.Question;
import com.test.level.model.Response;
import com.test.level.model.Test;
import com.test.level.repository.entity.QuestionEntity;

@Component
public class QuestionPopulator extends AbstractPopulator<QuestionEntity, Question> {

	@Autowired
	private ResponsePopulator responsePopulator;

	@Override
	public Question toModel(QuestionEntity entity) {
		Question question = new Question();
		question.setId(entity.getId());
		question.setStatement(entity.getStatement());

//		question.setResponse(responsePopulator.populateList(entity.getResponse()));
		return question;
	}

	@Override
	public QuestionEntity toEntity(Question model) {
		QuestionEntity questionEntity = new QuestionEntity();
		questionEntity.setId(model.getId());
		questionEntity.setStatement(model.getStatement());
//		questionEntity.setResponse(responsePopulator.populateFrommodelList(model.getResponse()));
		return questionEntity;
	}

	@Override
	public QuestionEntity updateToEntity(Question model, QuestionEntity entity) {
		entity.setId(model.getId());
		entity.setStatement(model.getStatement());
//		entity.setResponse(responsePopulator.populateFrommodelList(model.getResponse()));
		return entity;
	}

}
