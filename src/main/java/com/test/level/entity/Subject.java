package com.test.level.entity;

public class Subject {
	private int id;
	private String nom;
	private Stream stream ;

	public Subject() {
		super();
	}

	public Subject(int id, String nom,Stream stream) {
		super();
		this.stream=stream ;
		this.id = id;
		this.nom = nom;
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
