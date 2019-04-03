package com.test.level.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.level.model.Stream;
import com.test.level.populator.StreamPopulator;
import com.test.level.repository.StreamRepository;
import com.test.level.repository.entity.StreamEntity;

@Service
public class StreamService {

	@Autowired
	private StreamRepository streamRepository;
	
	@Autowired
	private StreamPopulator streamPopulator;

	public List<Stream> getAllStreams() {
		return streamPopulator.populateList(streamRepository.findAll());
	}

	public Stream getStream(Long id) {
		return streamPopulator.toModel(streamRepository.getOne(id));
	}

	public boolean addStream(Stream stream) {
		return streamRepository.save(streamPopulator.toEntity(stream)) != null;
	}

	public boolean deleteStream(Long id) {
		return streamRepository.findById(id).map(stream -> {
			streamRepository.delete(stream);
			
			return true;
		}).orElse(false);
	}

	public boolean updateStream(Long id,Stream stream) {

		StreamEntity streamEntity = streamRepository.getOne(id);
		streamEntity.setNom(stream.getNom());
		streamEntity.setId(id);
		return streamRepository.save(streamEntity) != null;
	}

}
