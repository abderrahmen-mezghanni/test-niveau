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
@Table(name = "question")
public class QuestionEntity  extends AbstractEntity{
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "QUESTION_ID", unique = true, nullable = false)
	private Long id;

	
	@Column(name = "STATEMENT", unique = true, nullable = false, length = 60)
	private String statement;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "TEST_ID", nullable = false)
	private TestEntity test;
	
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "question", cascade = CascadeType.ALL, orphanRemoval = true)
	private List<ResponseEntity> Response;

	public QuestionEntity() {
		super();
	}

	public QuestionEntity(Long id, String statement, TestEntity test) {
		super();
		this.id = id;
		this.statement = statement;
		test = test;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getStatement() {
		return statement;
	}

	public void setStatement(String statement) {
		this.statement = statement;
	}

	public TestEntity getTest() {
		return test;
	}

	public void setTest(TestEntity test) {
		this.test = test;
	}

	public List<ResponseEntity> getResponse() {
		return Response;
	}

	public void setResponse(List<ResponseEntity> response) {
		Response = response;
	}




}
