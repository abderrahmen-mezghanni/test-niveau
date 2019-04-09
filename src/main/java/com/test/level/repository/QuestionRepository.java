package com.test.level.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.level.repository.entity.QuestionEntity;
import com.test.level.repository.entity.TestEntity;
@Repository
public interface QuestionRepository extends JpaRepository<QuestionEntity, Long>{

//List<QuestionEntity> findByTestId(Long testId);
	
	
	@Query(value = "select * from question q inner join test t on q.TEST_ID = t.TEST_ID and q.TEST_ID=?1 inner join level l on t.LEVEL_ID = l.LEVEL_ID and t.LEVEL_ID=?2 inner join subject sb on l.SUBJECT_ID = sb.SUBJECT_ID and l.SUBJECT_ID=?3 inner join stream st on sb.STREAM_ID = st.STREAM_ID and sb.STREAM_ID=?4 WHERE q.QUESTION_ID=?5"
			, nativeQuery = true)
	QuestionEntity findQuestion(Long TEST_ID,Long LEVEL_ID,Long SUBJECT0_ID,Long STEAM_ID,Long QUESTION_ID);
	
	@Query(value ="select * from question q inner join test t on q.TEST_ID = t.TEST_ID and q.TEST_ID=?1 inner join level l on t.LEVEL_ID = l.LEVEL_ID and t.LEVEL_ID=?2 inner join subject sb on l.SUBJECT_ID = sb.SUBJECT_ID and l.SUBJECT_ID=?3 inner join stream st on sb.STREAM_ID = st.STREAM_ID and sb.STREAM_ID=?4"
			, nativeQuery = true)
	List<QuestionEntity> findAllQuestion(Long TEST_ID,Long LEVEL_ID,Long SUBJECT0_ID,Long STEAM_ID);
}
