package com.test.level.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.level.entity.Administrator;

@Service
public class AdministratorService {

	private List<Administrator> administrators = new ArrayList<>();

	public AdministratorService() {
		super();
		this.administrators.addAll(Arrays.asList(new Administrator(055, 55, "mahamed", "salah"),
				new Administrator(458, 55, "salah", "mohamed"), new Administrator(420, 47, "salah", "salah55")));
	}

	public List<Administrator> getAllAdministrators() {
		return administrators;
	}

	public Administrator getAdministrator(int id) {
		return administrators.stream().filter(e -> e.getId() == id).findFirst().get();

	}

	public boolean addAdministrator(Administrator administrator) {
		return administrators.add(administrator);
	}

	public boolean deleteAdministrator(int id) {

		administrators.removeIf(a -> a.getId() == id);
		return true;
	}

	public boolean addAllAdministrators(List<Administrator> administrators) {
		// TODO implement all etudiant
		return false;
	}

	/**
	 * Method that update student
	 * 
	 * @param etudiant
	 * @return
	 */
	public boolean updateAdministrator(int id, Administrator administrator) {
		for (int i = 0; i < administrators.size(); i++) {
			Administrator a = administrators.get(i);
			if (a.getId() == administrator.getId()) {
				administrators.set(i, administrator);
				return true;
			}

		}
		return false;

	}

}
