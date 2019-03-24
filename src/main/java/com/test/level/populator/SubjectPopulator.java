package com.test.level.populator;

import org.springframework.stereotype.Component;

import com.test.level.model.Subject;
import com.test.level.repository.entity.SubjectEntity;

@Component
public class SubjectPopulator extends AbstractPopulator<SubjectEntity, Subject> {

	@Override
	public Subject toModel(SubjectEntity entity) {
		Subject subject = new Subject();
		subject.setId(entity.getId());
		subject.setNom(entity.getNom());
		return subject;
	}

	@Override
	public SubjectEntity toEntity(Subject model) {
		SubjectEntity subject = new SubjectEntity();
		subject.setId(model.getId());
		subject.setNom(model.getNom());
		return subject;
	}

	@Override
	public SubjectEntity updateToEntity(Subject model, SubjectEntity entity) {
		entity.setNom(model.getNom());
		return entity;
	}

}
