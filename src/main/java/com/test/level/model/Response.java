package com.test.level.model;

public class Response {
	private int id;
	private String statement;
	private Question question;
	private boolean verify;

	public Response() {
		super();

	}

	public Response(int id, String statement, Question question, boolean verify) {
		super();
		this.id = id;
		this.statement = statement;
		this.question = question;
		this.verify = verify;
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

	public Question getQuestion() {
		return question;
	}

	public void setQuestion(Question question) {
		this.question = question;
	}

	public boolean isVerify() {
		return verify;
	}

	public void setVerify(boolean verify) {
		this.verify = verify;
	}

}
