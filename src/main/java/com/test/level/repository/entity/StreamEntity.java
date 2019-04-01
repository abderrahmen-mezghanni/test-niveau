package com.test.level.repository.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "stream")
public class StreamEntity extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "STREAM_ID", unique = true, nullable = false)
	private Long id;

	@Column(name = "STREAM_NAME", unique = true, nullable = false, length = 60)
	private String nom;

	
//	3, cascade = CascadeType.ALL
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "stream", orphanRemoval = true)
	private List<SubjectEntity> subjects;

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

	public List<SubjectEntity> getSubjects() {
		return subjects;
	}

	public void setSubjects(List<SubjectEntity> subjects) {		
		for(SubjectEntity s : subjects){
			s.setStream(this);
		}
		this.subjects = subjects;
	}

	public StreamEntity(Long id, String nom, List<SubjectEntity> subjects) {
		super();
		this.id = id;
		this.nom = nom;
		this.subjects = subjects;
	}

	public StreamEntity() {
		super();
	}

}