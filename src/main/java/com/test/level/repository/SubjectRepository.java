package com.test.level.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.level.repository.entity.StreamEntity;
import com.test.level.repository.entity.SubjectEntity;

@Repository
public interface SubjectRepository extends JpaRepository<SubjectEntity, Long> {
	List<SubjectEntity> findByStreamId(Long streamId);

}
