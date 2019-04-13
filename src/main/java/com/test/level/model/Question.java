package com.test.level.model;

import java.util.List;

public class Question extends AbstractModel {
	private Long id;
	private String statement;
	private Test test;
	private List <Response> responses ;

	public Question() {
		super();

	}

	public Question(Long id, String statement, Test test,List<Response> responses) {
		super();
		this.id = id;
		this.statement = statement;
		this.test = test;
		this.responses=responses;
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

	public Test getTest() {
		return test;
	}

	public void setTest(Test test) {
		this.test = test;
	}

	public List<Response> getResponse() {
		return responses;
	}

	public void setResponse(List<Response> responses) {
		this.responses = responses;
	}

	

}
