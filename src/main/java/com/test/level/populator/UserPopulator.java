package com.test.level.populator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.test.level.model.User;
import com.test.level.repository.entity.UserEntity;
@Component
public class UserPopulator extends AbstractPopulator<UserEntity, User> {
	
	@Autowired
	private RolePopulator rolePopulator;

		@Override
		public User toModel(UserEntity entity) {
			User user = new User();
			user.setCin(entity.getCin());
			user.setNom(entity.getNom());
			user.setPrenom(entity.getPrenom());
			user.setPassword(entity.getPassword());
			
			user.setRoles(rolePopulator.populateList(entity.getRoles()));
			return user;
		}

		@Override
		public UserEntity toEntity(User model) {
			UserEntity user = new UserEntity();
			user.setCin(model.getCin());
			user.setNom(model.getNom());
			user.setPrenom(model.getPrenom());
			user.setPassword(model.getPassword());
			user.setRoles(rolePopulator.populateFrommodelList(model.getRoles()));
			return user;
		}

		@Override
		public UserEntity updateToEntity(User model, UserEntity entity) {
			entity.setCin(model.getCin());
			entity.setNom(model.getNom());
			entity.setPrenom(model.getPrenom());
			entity.setPassword(model.getPassword());
			entity.setRoles(rolePopulator.populateFrommodelList(model.getRoles()));
			return entity;
		}

}
