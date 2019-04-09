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
	
	
	@Query(value = "SELECT * FROM level l inner join subject sb on l.SUBJECT_ID = sb.SUBJECT_ID inner join stream st on sb.STREAM_ID = st.STREAM_ID and sb.STREAM_ID=?1 WHERE l.SUBJECT_ID =?2 and l.LEVEL_ID =?3"
			, nativeQuery = true)
	ResponseEntity findResponse(Long STEAM_ID, Long SUBJECT0_ID, Long LEVEL_ID, Long TEST_ID,Long QUESTION_ID,Long RESPONSE_ID);
	
	@Query(value = "SELECT * FROM level l inner join subject sb on l.SUBJECT_ID = sb.SUBJECT_ID inner join stream st on sb.STREAM_ID = st.STREAM_ID and sb.STREAM_ID=?1 WHERE l.SUBJECT_ID =?2"
			, nativeQuery = true)
	List<ResponseEntity> findAllResponse(Long STEAM_ID, Long SUBJECT0_ID,Long LEVEL_ID,Long TEST_ID,Long QUESTION_ID);
	
}
