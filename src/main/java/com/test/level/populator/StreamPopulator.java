package com.test.level.populator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.level.model.Stream;
import com.test.level.repository.entity.StreamEntity;

@Component
public class StreamPopulator extends AbstractPopulator<StreamEntity, Stream> {
	
	@Autowired
	private SubjectPopulator subjectPopulator;

	@Override
	public Stream toModel(StreamEntity entity) {
		Stream stream = new Stream();
		stream.setId(entity.getId());
		stream.setNom(entity.getNom());
		stream.setSubjects(subjectPopulator.populateList(entity.getSubjects()));
		return stream;
	}

	@Override
	public StreamEntity toEntity(Stream model) {
		StreamEntity stream = new StreamEntity();
		stream.setId(model.getId());
		stream.setNom(model.getNom());
		stream.setSubjects(subjectPopulator.populateFrommodelList(model.getSubjects()));
		return stream;
	}

	@Override
	public StreamEntity updateToEntity(Stream model, StreamEntity entity) {
		entity.setId(model.getId());
		entity.setNom(model.getNom());
		entity.setSubjects(subjectPopulator.populateFrommodelList(model.getSubjects()));
		return entity;
	}
	

}
