package com.test.level.populator;

import org.springframework.stereotype.Component;

import com.test.level.model.Test;
import com.test.level.repository.entity.TestEntity;
@Component
public class TestPopulator extends AbstractPopulator<TestEntity, Test> {


		@Override
		public Test toModel(TestEntity entity) {
			Test test = new Test();
			test.setId(entity.getId());
			return test;
		}

		@Override
		public TestEntity toEntity(Test model) {
			TestEntity test = new TestEntity();
			test.setId(model.getId());
			return test;
		}

		@Override
		public TestEntity updateToEntity(Test model, TestEntity entity) {
			entity.setId(model.getId());
			return entity;
		}

}
