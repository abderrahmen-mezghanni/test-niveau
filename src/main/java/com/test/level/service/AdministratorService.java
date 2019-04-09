package com.test.level.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.test.level.model.Administrator;
import com.test.level.model.Level;
import com.test.level.model.Subject;
import com.test.level.model.User;
import com.test.level.populator.UserPopulator;
import com.test.level.repository.UserRepository;
import com.test.level.repository.entity.AdministratorEntity;


@Service
public class AdministratorService {

	@Autowired
	private UserRepository userRepository;

	@Autowired
	private UserPopulator userPopulator;

	public List<User> getAllAdministrtors() {
		return userPopulator.populateList(userRepository.findAllAdministrators());
	}

	public Administrator findAdministrator(Long administratorId) {
		Administrator administrator = (Administrator) userPopulator
				.toModel(userRepository.findAdministrator(administratorId));
		return administrator;

	}

	public boolean addAdministrator(Administrator administrator) {
		AdministratorEntity administratorEntity = (AdministratorEntity) userPopulator.toEntity(administrator);
		return userRepository.save(administratorEntity) != null;
	}

	public boolean deleteAdministrator(Long administratorId) {
		return userRepository.findById(administratorId).map(administrator -> {
			userRepository.delete(administrator);
			return true;
		}).orElse(false);
	}
	
	public boolean updateAdministrator(long id ,Administrator administrator) {

		return false;
	}

}
