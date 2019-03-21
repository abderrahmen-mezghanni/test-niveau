package com.test.level.entity;

public class Subject {
	private int id;
	private String nom;
	private Steam steam ;

	public Subject() {
		super();
	}

	public Subject(int id, String nom,Steam steam) {
		super();
		this.steam=steam ;
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
