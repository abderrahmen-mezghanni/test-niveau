package com.test.level.repository.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "level")
public class LevelEntity extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LEVEL_ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "LEVEL_NAME", unique = true, nullable = false, length = 60)
	private String nom;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "SUBJECT_ID", nullable = false)
	private SubjectEntity subject;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "level", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<TestEntity> tests;
	
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

	public SubjectEntity getSubject() {
		return subject;
	}

	public void setSubject(SubjectEntity subject) {
		this.subject = subject;
	}

	public LevelEntity() {
		super();
	}

	public LevelEntity(Long id, String nom, SubjectEntity subject) {
		super();
		this.id = id;
		this.nom = nom;
		this.subject = subject;
	}

	public List<TestEntity> getTests() {
		return tests;
	}

	public void setTests(List<TestEntity> tests) {
		this.tests = tests;
	}

}
