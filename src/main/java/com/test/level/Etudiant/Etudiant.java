package com.test.level.Etudiant;

public class Etudiant {
	private int cin;
	private String nom;
	private String prenonom;
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Etudiant() {

	}

	public Etudiant(int cin, String nom, String prenonom) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenonom = prenonom;
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
