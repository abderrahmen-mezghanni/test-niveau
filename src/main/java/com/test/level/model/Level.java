package com.test.level.model;

public class Level extends AbstractModel {
	private Long id;
	private String nom;
	private Subject subject ;
	
	public Level() {
		super();
	
	}
	public Level(Long id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
		
	}

	public Level(Long id, String nom, Subject subject) {
		super();
		this.id = id;
		this.nom = nom;
		this.subject = subject;
	}

	public Subject getSubject() {
		return subject;
	}

	public void setSubject(Subject subject) {
		this.subject = subject;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
