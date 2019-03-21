package com.test.level.Etudiant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class EtudiantService {
	private List<Etudiant> etudiants = new ArrayList<>();

	public EtudiantService() {
		super();
		this.etudiants.addAll(Arrays.asList(new Etudiant(055, "mahamed", "salah"),
				new Etudiant(458, "salah", "mohamed"), new Etudiant(420, "salah", "salah55")));
	}


	public List<Etudiant> getAllEtudiants() {
		return etudiants;
	}

	public Etudiant getEtudiant(String nom) {
		return etudiants.stream().filter(e -> e.getNom().equals(nom)).findFirst().get();

	}

	public boolean addEtudiant(Etudiant etudiant) {
		return etudiants.add(etudiant);
	}
	
	public boolean deleteEtudiants(Etudiant etudiant) {
		//TODO implemetn delete
		return false;
	}

	public boolean addAllEtudiants(List<Etudiant> etudiants) {
		//TODO implement all etudiant
		return false;
	}

	/**
	 * Method that update student
	 * 
	 * @param etudiant
	 * @return
	 */
	public boolean updateEtudiant(Etudiant etudiant) {
		//TODO implement update
		return false;
	}

}
