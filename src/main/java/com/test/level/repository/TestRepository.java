package com.test.level.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.level.repository.entity.LevelEntity;
import com.test.level.repository.entity.TestEntity;
@Repository
public interface TestRepository extends JpaRepository<TestEntity, Long> {
	
//	List<TestEntity> findByLevelId(Long levelId);
	
	
	@Query(value = "select * from test t inner join level l on t.LEVEL_ID = l.LEVEL_ID and t.LEVEL_ID=?1 inner join subject sb on l.SUBJECT_ID = sb.SUBJECT_ID and l.SUBJECT_ID=?2 inner join stream st on sb.STREAM_ID = st.STREAM_ID and sb.STREAM_ID=?3 WHERE t.TEST_ID=?4"
			, nativeQuery = true)
	TestEntity findTest(Long LEVEL_ID,Long SUBJECT0_ID,Long STEAM_ID, Long TEST_ID);
	
	@Query(value = "select * from test t inner join level l on t.LEVEL_ID = l.LEVEL_ID and t.LEVEL_ID=?1 inner join subject sb on l.SUBJECT_ID = sb.SUBJECT_ID and l.SUBJECT_ID=?2 inner join stream st on sb.STREAM_ID = st.STREAM_ID and sb.STREAM_ID=?3 "
			, nativeQuery = true)
	List<TestEntity> findAllTest(Long LEVEL_ID,Long SUBJECT0_ID,Long STEAM_ID);


}
