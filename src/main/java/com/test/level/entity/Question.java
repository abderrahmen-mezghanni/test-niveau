package com.test.level.entity;

public class Question {
	private int id;
	private String statement;
	private Test test;

	public Question() {
		super();

	}

	public Question(int id, String statement, Test test) {
		super();
		this.id = id;
		this.statement = statement;
		this.test = test;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
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
	

}
