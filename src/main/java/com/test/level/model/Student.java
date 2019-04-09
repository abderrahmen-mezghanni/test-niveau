package com.test.level.model;

import java.util.ArrayList;
import java.util.List;

public class Student extends User {

	public Student() {
		super();
	}

	public Student( Long cin, String nom, String prenom ,String password) {
		super( cin, nom, prenom,password);
		
		List<Role> roles= new ArrayList<Role>();
		roles.add(new Role("STUDENT","STUDENT"));
		this.setRoles(roles);
	}

}
