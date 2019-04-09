package com.test.level.model;

public class Test extends AbstractModel {
	private Long id;
	private Level level;

	public Test() {
		super();

	}

	public Test(Long id, Level level) {
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

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

}
