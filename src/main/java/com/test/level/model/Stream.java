package com.test.level.model;

import java.util.List;

public class Stream extends AbstractModel {
	private Long id;
	private String nom;
	private List<Subject> subjects;

	public Stream() {
		super();

	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public List<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<Subject> subjects) {
		this.subjects = subjects;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
}
