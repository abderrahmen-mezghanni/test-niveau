package com.test.level.model;

public class Role extends AbstractModel {
	private String role;
	private String description;
	public Role() {
		super();
	}
	public Role(String role, String description) {
		super();
		this.role = role;
		this.description = description;
	}
	public String getRole() {
		return role;
	}
	public void setRole(String role) {
		this.role = role;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
