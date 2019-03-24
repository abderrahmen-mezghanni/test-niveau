package com.test.level.model;

public class Test {
	private int id;
	private Level level;

	public Test() {
		super();

	}

	public Test(int id, Level level) {
		super();
		this.id = id;
		this.level = level;
	}

	public Level getLevel() {
		return level;
	}

	public void setLevel(Level level) {
		this.level = level;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

}
