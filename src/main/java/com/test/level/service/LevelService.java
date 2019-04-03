package com.test.level.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.level.model.Level;
import com.test.level.model.Subject;
import com.test.level.populator.LevelPopulator;
import com.test.level.populator.SubjectPopulator;
import com.test.level.repository.LevelRepository;
import com.test.level.repository.entity.LevelEntity;
import com.test.level.repository.entity.SubjectEntity;

@Service
public class LevelService {

	
	@Autowired
	private LevelRepository levelRepository;
	
	@Autowired
	private LevelPopulator levelPopulator;
	
	@Autowired
	private SubjectService subjectService;
	
	@Autowired
	private SubjectPopulator subjectPopulator;
	
	public List<Level> getAllLevels() {
		return levelPopulator.populateList(levelRepository.findAll());
	}
	public Level findLevel(Long id,Long subjectId,Long streamId) {
		Level level =levelPopulator.toModel(levelRepository.findLevel( streamId, subjectId,id));
		level.setSubject(subjectService.getSubject(subjectId,streamId));
		return level;
	
	}
	
	
	public List<Level> findAllLevels(Long subjectId,Long streamId) {
		List <Level> levels = levelPopulator.populateList(levelRepository.findAllLevel( streamId, subjectId));
//		level.setSubject(subjectService.getSubject(subjectId,streamId));
		for (int i=0; i<levels.size();i++) {
			Level level=levels.get(i);
			level.setSubject(subjectService.getSubject(subjectId,streamId));
			levels.set(i,level);
		}
		return levels;
	
	}
	public Level getLevel(long id) {
		return levelRepository.findById(id).map(level -> {
			return levelPopulator.toModel(level);
		}).orElse(null);
	}
	public boolean addLevel(Level level, Long subjectId, Long streamId) {
		
		Subject subject= subjectService.getSubject(subjectId, streamId);
		SubjectEntity subjectEntity = subjectPopulator.toEntity(subject);
		LevelEntity levelEntity = levelPopulator.toEntity(level);
		levelEntity.setSubject(subjectEntity);
		
			return levelRepository.save(levelEntity) != null;
		
	}
	
	public List<Level> getLevelsBySubjectId(Long subjectId) {		
		return levelPopulator.populateList(levelRepository.findBySubjectId(subjectId)) ;
	}
	public Level getLevel(Long id, Long subjectId) {
		List<Level> list = getLevelsBySubjectId(subjectId);
		Level L = new Level();
		for (int i = 0; i < list.size(); i++)
			if (list.get(i).getId() == id) {
				L = list.get(i);
				break;
			}
		return L;
	}
	public boolean deleteLevel(Long id) {
		return levelRepository.findById(id).map(stream -> {
			levelRepository.delete(stream);
			return true;
		}).orElse(false);
	}

	public boolean updateLevel(long id ,Level level) {
//		for (int i = 0; i < levels.size(); i++) {
//		Level a = levels.get(i);
//			if (a.getId() == level.getId()) {
//				levels.set(i, level);
//				return true;
//			}
//
//		}
		return false;
	}

}
