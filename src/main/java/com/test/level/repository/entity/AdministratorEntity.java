package com.test.level.repository.entity;

import java.util.ArrayList;
import java.util.List;

import com.test.level.model.Role;

public class AdministratorEntity extends UserEntity {

	public AdministratorEntity() {
		super();
	}

	public AdministratorEntity( Long cin, String nom, String prenom ,String password) {
	
		super( cin, nom, prenom,password);
		List<RoleEntity> roles= new ArrayList<RoleEntity>();
		roles.add(new RoleEntity("ADMIN","ADMIN"));
		roles.add(new RoleEntity("PROF","PROF"));
		this.setRoles(roles);
	}
	
}
