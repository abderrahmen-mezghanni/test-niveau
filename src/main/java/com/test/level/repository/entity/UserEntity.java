package com.test.level.repository.entity;


import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity(name="user")
@Table(name = "user")
public class UserEntity extends AbstractEntity{
	
	@Id
	@Column(name = "CIN", unique = true, nullable = false)
	private Long cin;
	
	@Column(name = "NOM", unique = true, nullable = false)
	private String nom;

	@Column(name = "PRENOM", unique = true, nullable = false)
	private String prenom;

	@Column(name = "PASSWORD", unique = true, nullable = false)
	private String password;
	
	@ManyToMany
	@JoinTable(name="user_role")
	private List<RoleEntity> role;
	

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



	public List<RoleEntity> getRole() {
		return role;
	}



	public void setRole(List<RoleEntity> role) {
		this.role = role;
	}



	



}
