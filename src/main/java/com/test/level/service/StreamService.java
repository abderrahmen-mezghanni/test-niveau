package com.test.level.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.level.model.Stream;

@Service
public class StreamService {

	private List<Stream> streams = new ArrayList<>();

	public StreamService() {
		super();
		this.streams.addAll(Arrays.asList(new Stream(01, "GII"), new Stream(02, "GT")));
	}

	public List<Stream> getAllStreams() {
		return streams;
	}

	public Stream getStream(int id) {
		return streams.stream().filter(e -> e.getId() == id).findFirst().get();

	}

	public boolean addStream(Stream steam) {
		return streams.add(steam);
	}

	public boolean deleteStream(int id) {
		streams.removeIf(a ->a.getId()==id);
		return true;
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
	public boolean updateStream(int id ,Stream stream) {
		for (int i = 0; i < streams.size(); i++) {
			Stream a = streams.get(i);
			if (a.getId() == stream.getId()) {
				streams.set(i, stream);
				return true;
			}

		}		return false;
	}

}
