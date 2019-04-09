package com.test.level.model;


import java.util.List;

public class User extends AbstractModel{

	private Long cin;
	private String nom;
	private String prenom;
	private String password;
	private List<Role> roles;

	public User() {
		super();
	}

	
	
	public User(Long cin, String nom, String prenom, String password, List<Role> roles) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
		this.roles = roles;
	}



	public User(Long cin, String nom, String prenom, String password) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
	}

	public Long getCin() {
		return cin;
	}

	public void setCin(Long cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Role> getRoles() {
		return roles;
	}

	public void setRoles(List<Role> roles) {
		this.roles = roles;
	}

}
