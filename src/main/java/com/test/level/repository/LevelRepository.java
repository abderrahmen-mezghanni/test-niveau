package com.test.level.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.level.model.Level;
import com.test.level.repository.entity.LevelEntity;

@Repository
public interface LevelRepository extends JpaRepository<LevelEntity, Long> {
	List<LevelEntity> findBySubjectId(Long subjectId);
	
	
	@Query(value = "SELECT * FROM level l inner join subject sb on l.SUBJECT_ID = sb.SUBJECT_ID inner join stream st on sb.STREAM_ID = st.STREAM_ID and sb.STREAM_ID=?1 WHERE l.SUBJECT_ID =?2 and l.LEVEL_ID =?3"
			, nativeQuery = true)
	LevelEntity findLevel(Long STEAM_ID, Long SUBJECT0_ID, Long LEVEL_ID);
	
	@Query(value = "SELECT * FROM level l inner join subject sb on l.SUBJECT_ID = sb.SUBJECT_ID inner join stream st on sb.STREAM_ID = st.STREAM_ID and sb.STREAM_ID=?1 WHERE l.SUBJECT_ID =?2"
			, nativeQuery = true)
	List<LevelEntity> findAllLevel(Long STEAM_ID, Long SUBJECT0_ID);

	
}
