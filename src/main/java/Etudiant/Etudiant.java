package Etudiant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class Etudiant {
	private int cin;
	private String nom;
	private String prenonom;

	public static void main(String[] args) {

		SpringApplication.run(Etudiant.class, args);
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
