package com.test.level.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;


import com.test.level.repository.entity.UserEntity;
@Repository
public interface UserRepository extends JpaRepository<UserEntity, Long> {

	@Query(value = "SELECT * FROM user u inner join user_role ur on u.CIN = ur.USER_CIN inner join role rl on ur.ROLE_ROLE = rl.ROLE and ur.ROLE_ROLE='ADMIN' WHERE u.CIN =?1"
			, nativeQuery = true)
	UserEntity findAdministrator(Long ADMINISTRATOR_CIN);
	
	@Query(value = "SELECT * FROM user u inner join user_role ur on u.CIN = ur.USER_CIN inner join role rl on ur.ROLE_ROLE = rl.ROLE and ur.ROLE_ROLE='ADMIN'"
			, nativeQuery = true)
	List<UserEntity> findAllAdministrators();
	
	
	@Query(value = "SELECT * FROM user u inner join user_role ur on u.CIN = ur.USER_CIN inner join role rl on ur.ROLE_ROLE = rl.ROLE and ur.ROLE_ROLE='PROF' WHERE u.CIN =?1"
			, nativeQuery = true)
	UserEntity findProfessor(Long PROFESSOR_CIN);
	
	@Query(value = "SELECT * FROM user u inner join user_role ur on u.CIN = ur.USER_CIN inner join role rl on ur.ROLE_ROLE = rl.ROLE and ur.ROLE_ROLE='PROF'"
			, nativeQuery = true)
	List<UserEntity> findAllProfessors();

	
	@Query(value = "SELECT * FROM user u inner join user_role ur on u.CIN = ur.USER_CIN inner join role rl on ur.ROLE_ROLE = rl.ROLE and ur.ROLE_ROLE='STUDENT' WHERE u.CIN =?1"
			, nativeQuery = true)
	UserEntity findStudent(Long PROFESSOR_CIN);
	
	@Query(value = "SELECT * FROM user u inner join user_role ur on u.CIN = ur.USER_CIN inner join role rl on ur.ROLE_ROLE = rl.ROLE and ur.ROLE_ROLE='STUDENT'"
			, nativeQuery = true)
	List<UserEntity> findAllStudents();
	

}
