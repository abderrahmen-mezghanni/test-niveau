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
			user.setRole(rolePopulator.populateList(entity.getRole()));
			return user;
		}

		@Override
		public UserEntity toEntity(User model) {
			UserEntity user = new UserEntity();
			user.setCin(model.getCin());
			user.setNom(model.getNom());
			user.setPrenom(model.getPrenom());
			user.setPassword(model.getPassword());
			user.setRole(rolePopulator.populateFrommodelList(model.getRole()));
			return user;
		}

		@Override
		public UserEntity updateToEntity(User model, UserEntity entity) {
			entity.setCin(model.getCin());
			entity.setNom(model.getNom());
			entity.setPrenom(model.getPrenom());
			entity.setPassword(model.getPassword());
			entity.setRole(rolePopulator.populateFrommodelList(model.getRole()));
			return entity;
		}

}
