package Matiere;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class MatiereController {

	@RequestMapping("/matiere")
	public String matiereList() {
		return "<h1>proba</h1>";

	}
}
