package com.test.level.populator;

import org.springframework.stereotype.Component;

import com.test.level.model.Question;
import com.test.level.model.Response;
import com.test.level.repository.entity.QuestionEntity;
import com.test.level.repository.entity.ResponseEntity;
@Component
public class ResponsePopulator extends AbstractPopulator<ResponseEntity,Response> {

//			@Autowired
//			private TestPopulator testPopulator;
		
		
			@Override
			public Response toModel(ResponseEntity entity) {
				Response response = new Response();
				response.setId(entity.getId());
				response.setStatement(entity.getStatement());
				response.setVerify(entity.isVerify());

				return response;
			}

			@Override
			public ResponseEntity toEntity(Response model) {
				ResponseEntity responseEntity = new ResponseEntity();
				responseEntity.setId(model.getId());
				responseEntity.setStatement(model.getStatement());
				responseEntity.setVerify(model.isVerify());
//				responseEntity.setQuestion(questionPopulator.populateFrommodelList(model.getQuestion()));
				return responseEntity;
			}

			@Override
			public ResponseEntity updateToEntity(Response model, ResponseEntity entity) {
				entity.setId(model.getId());
				entity.setStatement(model.getStatement());
				entity.setVerify(model.isVerify());
//				entity.setQuestion(questionPopulator.populateFrommodelList(model.getQuestion()));
				return entity;
			}
	
	
}
