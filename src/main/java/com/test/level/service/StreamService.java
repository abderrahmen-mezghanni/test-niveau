package com.test.level.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.level.model.Stream;
import com.test.level.populator.StreamPopulator;
import com.test.level.repository.StreamRepository;

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

	public boolean addAllStreams(List<Stream> steams) {
		// TODO implement all etudiant
		return false;
	}

	/**
	 * Method that update student
	 * 
	 * @param etudiant
	 * @return
	 */
	public boolean updateStream(Long id) {
//		for (int i = 0; i < streams.size(); i++) {
//			Stream a = streams.get(i);
//			if (a.getId() == stream.getId()) {
//				streams.set(i, stream);
//				return true;
//			}
//
//		}
		return false;
	}

}
