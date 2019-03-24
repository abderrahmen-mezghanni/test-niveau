package com.test.level.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.test.level.model.Response;
@Service
public class ResponseService {

	

		private List<Response> responses = new ArrayList<>();

		public ResponseService() {
			super();
			this.responses.addAll(Arrays.asList(new Response(01, "chkoun?", null , true), new Response(22, "kifech", null, false)));
		}

		public List<Response> getAllResponses() {
			return responses;
		}

		public Response getResponse(int id) {
			return responses.stream().filter(e -> e.getId() == id).findFirst().get();

		}

		public boolean addResponse(Response response) {
			return responses.add(response);
		}

		public boolean deleteResponse(int id) {
			responses.removeIf(a ->a.getId()==id);
			return true;
		}

		public boolean addAllResponses(List<Response> responses) {
			// TODO implement all etudiant
			return false;
		}

		/**
		 * Method that update student
		 * 
		 * @param etudiant
		 * @return
		 */
		public boolean updateResponse(int id ,Response response) {
			for (int i = 0; i < responses.size(); i++) {
				Response a = responses.get(i);
				if (a.getId() == response.getId()) {
					responses.set(i, response);
					return true;
				}

			}
			return false;
		}

	}


