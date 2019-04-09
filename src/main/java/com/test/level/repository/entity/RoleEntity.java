package com.test.level.repository.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name = "role")
public class RoleEntity  extends AbstractEntity{
	@Id
	private String role;
	private String description;
	
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
	public RoleEntity(String role, String description) {
		super();
		this.role = role;
		this.description = description;
	}
	public RoleEntity() {
		super();
	}

}
