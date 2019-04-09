package com.test.level.populator;

import org.springframework.stereotype.Component;

import com.test.level.model.Role;
import com.test.level.repository.entity.RoleEntity;

@Component
public class RolePopulator extends AbstractPopulator<RoleEntity, Role> {
	@Override
	public Role toModel(RoleEntity entity) {
		Role role = new Role();
		role.setRole(entity.getRole());
		role.setDescription(entity.getDescription());
		return role;
	}

	@Override
	public RoleEntity toEntity(Role model) {
		RoleEntity roleEntity = new RoleEntity();
		roleEntity.setRole(model.getRole());
		roleEntity.setDescription(model.getDescription());
		return roleEntity;
	}

	@Override
	public RoleEntity updateToEntity(Role model, RoleEntity entity) {
		entity.setRole(model.getRole());
		entity.setDescription(model.getDescription());
		return entity;
	}

}
