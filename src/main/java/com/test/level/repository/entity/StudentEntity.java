package com.test.level.repository.entity;

import java.util.ArrayList;
import java.util.List;

public class StudentEntity extends UserEntity {

	public StudentEntity() {
		super();
	}

	public StudentEntity(Long cin, String nom, String prenom, String password) {

		super(cin, nom, prenom, password);
		List<RoleEntity> roles = new ArrayList<RoleEntity>();
		roles.add(new RoleEntity("STUDENT", "STUDENT"));
		this.setRoles(roles);
	}
}
