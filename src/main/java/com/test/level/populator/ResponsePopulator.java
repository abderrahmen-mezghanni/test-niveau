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
				if (entity.getVerify()=="true")
			{response.setVerify(true);}
				return response;
			}

			@Override
			public ResponseEntity toEntity(Response model) {
				ResponseEntity responseEntity = new ResponseEntity();
				responseEntity.setId(model.getId());
				responseEntity.setStatement(model.getStatement());
				if (model.isVerify())
					{responseEntity.setVerify("true");}
				else
					{responseEntity.setVerify("false");}
//				responseEntity.setQuestion(questionPopulator.populateFrommodelList(model.getQuestion()));
				return responseEntity;
			}

			@Override
			public ResponseEntity updateToEntity(Response model, ResponseEntity entity) {
				entity.setId(model.getId());
				entity.setStatement(model.getStatement());
				if (model.isVerify())
					{entity.setVerify("true");}
				else
					{entity.setVerify("false");}
//				entity.setQuestion(questionPopulator.populateFrommodelList(model.getQuestion()));
				return entity;
			}
	
	
}
