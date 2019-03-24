package com.test.level.model;

public class Level {
	private int id;
	private String nom;
	private Subject subject ;
	
	public Level() {
		super();
	
	}
	public Level(int id, String nom) {
		super();
		this.id = id;
		this.nom = nom;
		
	}

	public Level(int id, String nom, Subject subject) {
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

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}
}
