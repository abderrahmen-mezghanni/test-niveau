package com.test.level.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.test.level.repository.entity.QuestionEntity;
import com.test.level.repository.entity.ResponseEntity;
@Repository
public interface ResponseRepository extends JpaRepository<ResponseEntity, Long>{

//List<ResponseEntity> findByQuestionId(Long questionId);
	
	
	@Query(value = "select * from response r inner join question q on r.QUESTION_ID= q.QUESTION_ID and r.QUESTION_ID=?1 inner join test t on q.TEST_ID = t.TEST_ID and q.TEST_ID=?2 inner join level l on t.LEVEL_ID = l.LEVEL_ID and t.LEVEL_ID=?3 inner join subject sb on l.SUBJECT_ID = sb.SUBJECT_ID and l.SUBJECT_ID=?4 inner join stream st on sb.STREAM_ID = st.STREAM_ID and sb.STREAM_ID=?5WHERE r.RESPONSE_ID=?6"
			, nativeQuery = true)
	ResponseEntity findResponse(Long QUESTION_ID,Long TEST_ID,Long LEVEL_ID,Long SUBJECT0_ID,Long STEAM_ID,Long RESPONSE_ID);
	
	@Query(value = "select * from response r inner join question q on r.QUESTION_ID= q.QUESTION_ID and r.QUESTION_ID=?1 inner join test t on q.TEST_ID = t.TEST_ID and q.TEST_ID=?2 inner join level l on t.LEVEL_ID = l.LEVEL_ID and t.LEVEL_ID=?3 inner join subject sb on l.SUBJECT_ID = sb.SUBJECT_ID and l.SUBJECT_ID=?4 inner join stream st on sb.STREAM_ID = st.STREAM_ID and sb.STREAM_ID=?5 "
			, nativeQuery = true)
	List<ResponseEntity> findAllResponse(Long QUESTION_ID,Long TEST_ID,Long LEVEL_ID,Long SUBJECT0_ID,Long STEAM_ID);
	
}
