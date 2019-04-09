package com.test.level.model;

import java.util.ArrayList;
import java.util.List;

public class Professor extends User {

	public Professor() {
		super();

	}

	public Professor(Long cin, String nom, String prenom, String password) {
		super(cin, nom, prenom, password);
		
		List<Role> roles= new ArrayList<Role>();
		roles.add(new Role("PROF","PROF"));
		this.setRoles(roles);
	}

}
