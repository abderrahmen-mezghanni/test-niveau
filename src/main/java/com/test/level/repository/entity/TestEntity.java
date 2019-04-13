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
@Table(name = "test")
public class TestEntity extends AbstractEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "TEST_ID", unique = true, nullable = false)
	private Long id;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "LEVEL_ID", nullable = false)
	private LevelEntity level;

	@OneToMany(fetch = FetchType.EAGER, mappedBy = "test", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<QuestionEntity> Questions;

	public TestEntity() {
		super();
	}

	public List<QuestionEntity> getQuestions() {
		return Questions;
	}

	public void setQuestions(List<QuestionEntity> questions) {
		Questions = questions;
	}

	public TestEntity(Long id, LevelEntity level) {
		super();
		this.id = id;
		this.level = level;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public LevelEntity getLevel() {
		return level;
	}

	public void setLevel(LevelEntity level) {
		this.level = level;
	}
}
