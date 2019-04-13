package com.test.level.repository.entity;

import java.util.ArrayList;
import java.util.List;

public class ProfessorEntity extends UserEntity{

	
	public ProfessorEntity() {
		super();
	}

	public ProfessorEntity( Long cin, String nom, String prenom ,String password) {
	
		super( cin, nom, prenom,password);
		List<RoleEntity> roles= new ArrayList<RoleEntity>();
		roles.add(new RoleEntity("PROF","PROF"));
		this.setRole(roles);
	}
}
