package controller;

import java.util.Date;
import java.util.List;

import javax.annotation.Resource;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import fr.soro.entities.Emprunt;
import fr.soro.service.EmpruntService;

@CrossOrigin("*")
@RestController
public class EmpruntController {
	
	@Autowired
	public EmpruntService empruntService;
	
	
	
	@PostMapping(value = "/emprunts/{idUser}/{idExemplaire}")
	public ResponseEntity<Emprunt> createEmprunt(
			@PathVariable(value = "idUser") Long idUser, 
			@PathVariable(value = "idExemplaire") Long idExemplaire, 
			@RequestBody Emprunt emprunt
		)
	{
		Emprunt empruntsSaved = empruntService.save(idUser, idExemplaire, emprunt);
 		return new ResponseEntity<Emprunt>(empruntsSaved, HttpStatus.CREATED);
 	}
	
	@DeleteMapping(value = "/emprunts")
	public ResponseEntity<Void> deleteEmprunt(@RequestParam(value = "id", required = true) Long id) {
		
		empruntService.deleted(id);
		return new ResponseEntity<Void>(HttpStatus.GONE);
 	}

	
	@GetMapping(value = "/emprunts")
	public ResponseEntity<List<Emprunt>> getAllEmprunt() {
		List<Emprunt> empruntsUpdated = empruntService.getAllEmprunt();
		return new ResponseEntity<List<Emprunt>>(empruntsUpdated, HttpStatus.FOUND);
	}
	
	
	@GetMapping(value = "/emprunts/{id}")
	public ResponseEntity<Emprunt> getOneEmprunt(@PathVariable(value = "id") Long id) {
		Emprunt empruntsUpdated = empruntService.get(id);
		return new ResponseEntity<Emprunt>(empruntsUpdated, HttpStatus.FOUND);
	}
	
	@GetMapping(value = "/emprunts/{datedebut}")
	public ResponseEntity<List<Emprunt>> getDateDebut(@PathVariable(value = "datedebut") Date datedebut) {
		List<Emprunt> empruntsFound = empruntService.getDateDebut(datedebut);
		return new ResponseEntity<List<Emprunt>>(empruntsFound, HttpStatus.FOUND);
	}
	
	@GetMapping(value = "/emprunts/{dateEcheance}")
	public ResponseEntity<List<Emprunt>> getDateEcheance(@PathVariable(value = "dateEcheance") Date dateEcheance) {
		List<Emprunt> empruntsFound = empruntService.getDateEcheance(dateEcheance);
		return new ResponseEntity<List<Emprunt>>(empruntsFound, HttpStatus.FOUND);
	}
	
	@PutMapping(value = "/emprunts-prolongation/{idEmprunt}")
	public ResponseEntity<Emprunt> getProlongation(@PathVariable(value = "idEmprunt") Long idEmprunt) {
		Emprunt empruntsFound = empruntService.setProlongation(idEmprunt);
		return new ResponseEntity<Emprunt>(empruntsFound, HttpStatus.FOUND);
	}
	
	@GetMapping(value = "/emprunts/{depassement}")
	public ResponseEntity<List<Emprunt>> getDepassement(@PathVariable(value = "depassement") int depassement) {
		List<Emprunt> empruntsFound = empruntService.getDepassement(depassement);
		return new ResponseEntity<List<Emprunt>>(empruntsFound, HttpStatus.FOUND);
	}

}
