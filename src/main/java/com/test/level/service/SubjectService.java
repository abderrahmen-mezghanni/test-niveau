package com.test.level.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.level.model.Stream;
import com.test.level.model.Subject;
import com.test.level.populator.StreamPopulator;
import com.test.level.populator.SubjectPopulator;
import com.test.level.repository.StreamRepository;
import com.test.level.repository.SubjectRepository;
import com.test.level.repository.entity.StreamEntity;
import com.test.level.repository.entity.SubjectEntity;

@Service
public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private SubjectPopulator subjectPopulator;
	
	@Autowired
	private StreamPopulator streamPopulator;
	
	@Autowired
	private StreamService streamService;

	public List<Subject> getAllSubjects() {
		return subjectPopulator.populateList(subjectRepository.findAll());
	}

	public Subject getSubject(Long id) {
		return subjectRepository.findById(id).map(subject -> {
			return subjectPopulator.toModel(subject);
		}).orElse(null);
	}

	public Subject getSubject(Long id, Long streamId) {
		List<Subject> L = getSubjectsByStreamId(streamId);
		Subject S = new Subject();
		for (int i = 0; i < L.size(); i++)
			if (L.get(i).getId() == id) {
				S = L.get(i);
				break;
			}
		return S;
	}

	public boolean addSubject(Subject subject) {
		StreamEntity stream = streamPopulator.toEntity(streamService.getStream(subject.getStream().getId()));
		SubjectEntity subjectEntity = subjectPopulator.toEntity(subject);
		subjectEntity.setStream(stream);
		return subjectRepository.save(subjectEntity) != null;
	}

	public boolean deleteSubject(Long id) {
		return subjectRepository.findById(id).map(subject -> {
			subjectRepository.delete(subject);
			return true;
		}).orElse(false);
	}

	public List<Subject> getSubjectsByStreamId(Long streamId) {
		return subjectPopulator.populateList(subjectRepository.findByStreamId(streamId));
	}


	public boolean updateSubject(Long id, Subject subject) {
//		for (int i = 0; i < subjects.size(); i++) {
//			Subject a = subjects.get(i);
//			if (a.getId() == subject.getId()) {
//				subjects.set(i, subject);
//				return true;
//			}
//
//		}
		return false;
	}

}