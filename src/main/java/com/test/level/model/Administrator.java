package com.test.level.model;


import java.util.ArrayList;
import java.util.List;

public class Administrator extends User{

	
	public Administrator() {
		super();
	}

	public Administrator( Long cin, String nom, String prenom ,String password) {
	
		super( cin, nom, prenom,password);
		List<Role> roles= new ArrayList<Role>();
		roles.add(new Role("ADMIN","ADMIN"));
		roles.add(new Role("PROF","PROF"));
		this.setRole(roles);
	}

}
