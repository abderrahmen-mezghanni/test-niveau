package Etudiant;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EtudiantController {
	@Autowired
	private EtudiantService etudiantService;

	@RequestMapping(value = "/etudiants", method = RequestMethod.GET)
	public List<Etudiant> etudiantList() {
		return etudiantService.getAllEtudiants();
	}

	@RequestMapping(value = "/etudiants/{nom}", method = RequestMethod.GET)
	public Etudiant getEtudiant(@PathVariable("nom") String nom) {
		return etudiantService.getEtudiant(nom);

	}

	@RequestMapping(value = "/etudiants", method = RequestMethod.POST, consumes="application/json")
	public ResponseEntity addEtudiant(@RequestBody Etudiant etudiant) {
		if (etudiantService.addEtudiant(etudiant) && false) {
			return new ResponseEntity<>(etudiant, HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Etudiant non ajouté", HttpStatus.BAD_REQUEST);
		}

	}
}
