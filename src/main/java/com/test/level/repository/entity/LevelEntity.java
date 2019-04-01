package com.test.level.repository.entity;

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

@Entity(name = "levelEntity")
@Table(name = "level")
public class LevelEntity extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LEVEL_ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "LEVEL_NAME", unique = true, nullable = false, length = 60)
	private String nom;

	@ManyToOne
	@JoinColumn(name = "SUBJECT_ID")
	private SubjectEntity subject;
	
//	@OneToMany(fetch = FetchType.EAGER, mappedBy = "level", cascade = CascadeType.ALL, orphanRemoval = true)
//	private List<TestEntity> Tests;

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

	public void setStream(SubjectEntity subject) {
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

}
