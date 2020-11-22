package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import fr.soro.entities.Bibliotheque;
import fr.soro.entities.Exemplaire;
import fr.soro.service.ExemplaireService;

@RestController
public class ExemplaireController {

	@Autowired
	private ExemplaireService exemplaireService;

	@PostMapping(value = "/exemplaires/{idOuvrage}/{idBiblio}")
	@Transactional
	public ResponseEntity<Exemplaire> createExemplaire(@PathVariable(value = "idOuvrage") Long idOuvrage, @PathVariable(value = "idBiblio") Long idBiblio, @RequestBody Exemplaire exemplaire) {
		Exemplaire exemplaireSaved = exemplaireService.save(idOuvrage, idBiblio, exemplaire);
		return new ResponseEntity<Exemplaire>(exemplaireSaved, HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/exemplaires-biblio/{idBiblio}")
	public ResponseEntity<List<Exemplaire>> getBiblioExemplaire(@PathVariable(value = "idBiblio") Long idBiblio,Bibliotheque biblio) {
		List<Exemplaire> allExemplaires = exemplaireService.getAll();
		List<Exemplaire> exemplaireByBiblio = new ArrayList<Exemplaire>();
		for (Exemplaire exemplaire : allExemplaires) {
		    if (exemplaire.getBibliotheque().getId()==idBiblio) {
		    	exemplaireByBiblio.add(exemplaire);
			}
		}
		    return new ResponseEntity<List<Exemplaire>>(exemplaireByBiblio, HttpStatus.FOUND);
	}

	@DeleteMapping(value = "/exemplaires")
	public ResponseEntity<Void> deleteExemplaire(@RequestParam(value = "id", required = true) Long id) {

		exemplaireService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.GONE);
	}

	@GetMapping(value = "/exemplaires")
	public ResponseEntity<List<Exemplaire>> getAllExemplaire() {
		List<Exemplaire> exemplaires = exemplaireService.getAll();
		return new ResponseEntity<List<Exemplaire>>(exemplaires, HttpStatus.FOUND);
	}

	@GetMapping(value = "/exemplaires/{id}")
	public ResponseEntity<Exemplaire> getOneExemplaire(@PathVariable(value = "id") Long id) {
		Exemplaire exemplairesFound = exemplaireService.getOneById(id);
		return new ResponseEntity<Exemplaire>(exemplairesFound, HttpStatus.FOUND);
	}
	
	@GetMapping("/ouvrages/{id}/exemplairecount")
	public Map<String, Object> getOuvrageCountBybibliotheque(@PathVariable(value = "id") Long ouvrageId){
		Map<String, Object> ouvrageCountBybiblio = exemplaireService.getExempleCountByBibliotheque(ouvrageId);
	return ouvrageCountBybiblio;
}


}
