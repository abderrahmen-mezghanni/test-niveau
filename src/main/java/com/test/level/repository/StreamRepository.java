package com.test.level.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.test.level.repository.entity.StreamEntity;

@Repository
public interface StreamRepository extends JpaRepository<StreamEntity, Long> {

}
