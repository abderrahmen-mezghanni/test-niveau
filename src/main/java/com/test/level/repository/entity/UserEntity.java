package com.test.level.repository.entity;


import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "user")
public class UserEntity extends AbstractEntity{
	
	@Id
	private Long cin;
	private String nom;
	private String prenom;
	private String password;
	@ManyToMany
	@JoinTable(name="user_role")
	private List<RoleEntity> roles;
	

	public UserEntity() {

	}

	

	public UserEntity(Long cin, String nom, String prenom, String password) {
		super();
		
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.password = password;
	
	}




	public long getCin() {
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



	public List<RoleEntity> getRoles() {
		return roles;
	}



	public void setRoles(List<RoleEntity> roles) {
		this.roles = roles;
	}



}
