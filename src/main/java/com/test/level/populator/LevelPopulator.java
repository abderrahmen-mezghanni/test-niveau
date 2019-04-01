package com.test.level.populator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.test.level.model.Level;
import com.test.level.repository.entity.LevelEntity;

@Component	
public class LevelPopulator extends AbstractPopulator<LevelEntity,Level>{
	
//		@Autowired
//		private TestPopulator testPopulator;

		@Override
		public Level toModel(LevelEntity entity) {
			Level level = new Level();
			level.setId(entity.getId());
			level.setNom(entity.getNom());
//			level.setTests(testPopulator.populateList(entity.getTests()));
			return level;
		}

		@Override
		public LevelEntity toEntity(Level model) {
			LevelEntity level = new LevelEntity();
			level.setId(model.getId());
			level.setNom(model.getNom());
//			level.settests(testPopulator.populateFrommodelList(model.getTests()));
			return level;
		}

		@Override
		public LevelEntity updateToEntity(Level model, LevelEntity entity) {
			entity.setId(model.getId());
			entity.setNom(model.getNom());
//			entity.setTests(TestPopulator.populateFrommodelList(model.getTests()));
			return entity;
		}
		

	}
