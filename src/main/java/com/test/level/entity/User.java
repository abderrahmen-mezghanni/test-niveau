package com.test.level.entity;

public class User {
	private int id;
	private int cin;
	private String nom;
	private String prenonom;
	

	public User() {

	}

	public User(int id, int cin,  String nom, String prenonom) {
		super();
		this.id = id;
		this.cin = cin;
		this.nom = nom;
		this.prenonom = prenonom;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public int getCin() {
		return cin;
	}

	public void setCin(int cin) {
		this.cin = cin;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenonom() {
		return prenonom;
	}

	public void setPrenonom(String prenonom) {
		this.prenonom = prenonom;
	}

}
