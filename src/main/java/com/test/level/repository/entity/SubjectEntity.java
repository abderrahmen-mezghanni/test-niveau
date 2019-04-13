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

@Entity
@Table(name = "subject")
public class SubjectEntity extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "SUBJECT_ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "SUBJECT_NAME", unique = true, nullable = false, length = 60)
	private String nom;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "STREAM_ID", nullable = false)
	private StreamEntity stream;
	
	public List<LevelEntity> getLevels() {
		return levels;
	}

	public void setLevels(List<LevelEntity> levels) {
		this.levels = levels;
	}

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "subject", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<LevelEntity> levels;
	
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

	public StreamEntity getStream() {
		return stream;
	}

	public void setStream(StreamEntity stream) {
		this.stream = stream;
	}

	public SubjectEntity() {
		super();
	}

	public SubjectEntity(Long id, String nom, StreamEntity stream) {
		super();
		this.id = id;
		this.nom = nom;
		this.stream = stream;
	}

}
