package com.test.level.model;

import java.util.List;

public class Question extends AbstractModel {
	private Long id;
	private String statement;
	private Test test;
	private List <Response> Response ;

	public Question() {
		super();

	}

	public Question(Long id, String statement, Test test) {
		super();
		this.id = id;
		this.statement = statement;
		this.test = test;
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
		return Response;
	}

	public void setResponse(List<Response> response) {
		Response = response;
	}

	

}
