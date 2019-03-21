package com.test.level.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.level.entity.Steam;
@Service
public class SteamService {


		

			private List<Steam> steams = new ArrayList<>();

			public SteamService() {
				super();
				this.steams.addAll(Arrays.asList(new Steam(01, "GII"), new Steam(02, "GT")));
			}

			public List<Steam> getAllSteams() {
				return steams;
			}

			public Steam getSteam(int id) {
				return steams.stream().filter(e -> e.getId() == id).findFirst().get();

			}

			public boolean addSteam(Steam steam) {
				return steams.add(steam);
			}

			public boolean deleteSteam(Steam steam) {
				// TODO implemetn delete
				return false;
			}

			public boolean addAllSteams(List<Steam> steams) {
				// TODO implement all etudiant
				return false;
			}

			/**
			 * Method that update student
			 * 
			 * @param etudiant
			 * @return
			 */
			public boolean updateSteam(Steam steam) {
				// TODO implement update
				return false;
			}

		}



