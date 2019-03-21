package com.test.level.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;
import com.test.level.entity.User;

@Service
public class UserService {
	private List<User> users = new ArrayList<>();

	public UserService() {
		super();
		this.users.addAll(Arrays.asList(new User(055,55, "mahamed", "salah"), new User(458,55, "salah", "mohamed"),
				new User(420,47, "salah", "salah55")));
	}

	public List<User> getAllUsers() {
		return users;
	}

	public User getUser(String nom) {
		return users.stream().filter(e -> e.getNom().equals(nom)).findFirst().get();

	}

	public boolean addUser(User user) {
		return users.add(user);
	}

	public boolean deleteUsers(User user) {
		// TODO implemetn delete
		return false;
	}

	public boolean addAllUsers(List<User> users) {
		// TODO implement all etudiant
		return false;
	}

	/**
	 * Method that update student
	 * 
	 * @param etudiant
	 * @return
	 */
	public boolean updateUser(User user) {
		// TODO implement update
		return false;
	}

}
